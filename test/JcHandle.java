package top.test;

import top.redoriental.webtransport.server.handle.SessionHandle;
import top.redoriental.webtransport.server.handle.StreamHandle;
import top.redoriental.webtransport.server.pojo.Request;

import java.util.Arrays;

public class JcHandle extends SessionHandle {
    public JcHandle(long sessionId, String address) {
        super(sessionId, address);
    }

    StreamHandle streamHandle;

    @Override
    public void onOpen(Request request) {
        new Thread(()->{
            streamHandle = new StreamHandle(false,this) {
                @Override
                public void onOpen(long l) {
                    System.out.println("stream open"+l);
                }

                @Override
                public void onStreamData(byte[] bytes) {

                }

                @Override
                public void onStreamFinish() {
                    System.out.println("send finish");
                }
            };
            super.openStream(streamHandle);
        }).start();
    }

    @Override
    public void onDatagram(byte[] bytes) {
//        System.out.println(Arrays.toString(bytes));
        this.sendDatagram(bytes);
    }

    @Override
    public StreamHandle onStream(boolean isbir) {
        return new StreamHandle(isbir,this) {
            @Override
            public void onOpen(long streamId) {
                System.out.println("in new stream id"+streamId);
            }

            @Override
            public void onStreamData(byte[] bytes) {
                this.write(bytes,this.getStreamId());
//                streamHandle.write(bytes,streamHandle.getStreamId());
            }

            @Override
            public void onStreamFinish() {
                System.out.println("finish stream");
            }
        };
    }

    @Override
    public void onSessionFinish() {
        System.out.println("finish");
    }
}
