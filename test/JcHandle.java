package top.test;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import top.redoriental.webtransport.server.handle.BidStreamHandle;
import top.redoriental.webtransport.server.handle.ServerSessionHandle;
import top.redoriental.webtransport.server.handle.UniStreamHandle;
import top.redoriental.webtransport.server.pojo.ServerSession;
import top.redoriental.webtransport.server.pojo.StreamSession;

import java.util.Arrays;


public class JcHandle extends ServerSessionHandle {

    ServerSession serverSession;
    @Override
    public void onOpen(ServerSession serverSession) {
    }

    @Override
    public void onDatagram(byte[] bytes) {
        try {
            System.out.println(Arrays.toString(bytes));
            this.serverSession.sendDatagram(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BidStreamHandle onBidStream() {
        return new BidStreamHandle() {
            @Override
            public void onOpen(StreamSession streamSession) {

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
        System.out.println("close");
    }
}
