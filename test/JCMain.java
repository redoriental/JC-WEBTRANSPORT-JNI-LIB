package top.test;

//import top.redoriental.webtransport.server.WebTransportServerEngine;

import top.redoriental.webtransport.client.WebTransportClientEngine;
import top.redoriental.webtransport.client.handle.*;

import top.redoriental.webtransport.client.pojo.ClientSession;
import top.redoriental.webtransport.client.pojo.StreamSession;
import top.redoriental.webtransport.server.WebTransportServerEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class JCMain {

    public static void main(String[] args) throws Exception {
        new Thread(()->{
            WebTransportServerEngine webTransportServerEngine = WebTransportServerEngine
                    .create();
            try {
                webTransportServerEngine
                        .setIpPort("127.0.0.1",10002)
                        .setHandle("/test",JcHandle.class)
                        .setTimeout(400000)
                        .setSsl("XXX.key","XXXX.crt")
                        .run();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(200);
        byte[] bytes = new byte[100];
        WebTransportClientEngine.createClient("https://XXXXXXX:10002/test", new ConnectStatusHandle() {
            @Override
            public ClientSessionHandle onSuccess() {
                return new ClientSessionHandle() {
                    ClientSession session;
                    @Override
                    public void onOpen(ClientSession clientSession) {
                        this.session = clientSession;
                    }

                    @Override
                    public void onDatagram(byte[] bytes) {
                        System.out.println(Arrays.toString(bytes));
                        try {
                            session.sendDatagram(bytes);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public BidStreamHandle onBidStream() {
                        System.out.println("client on bid");
                        return new BidStreamHandle() {
                            StreamSession streamSession;

                            @Override
                            public void onOpen(StreamSession streamSession) {
                                this.streamSession = streamSession;
                                System.out.println("client stream session");
                            }

                            @Override
                            public void onData(byte[] bytes) {
                                System.out.println(bytes);
                                streamSession.sendStreamData(bytes);
                            }

                            @Override
                            public void onClose() {

                            }
                        };
                    }

                    @Override
                    public UniStreamHandle onUniStream() {
                        return new UniStreamHandle() {
                            @Override
                            public void onOpen() {

                            }

                            @Override
                            public void onData(byte[] bytes) {

                            }

                            @Override
                            public void onClose() {

                            }
                        };
                    }

                    @Override
                    public void onSessionClose() {
                        System.out.println(" session close");
                    }
                };
            }

            @Override
            public void onError(String s) {

            }
        });
    }
}
