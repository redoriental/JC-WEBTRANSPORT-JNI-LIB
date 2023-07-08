package top.redoriental.webtransport.server.handle;

import top.redoriental.webtransport.server.local.ServerNative;
import top.redoriental.webtransport.server.pojo.Request;

public abstract class SessionHandle {

    public SessionHandle(long sessionId,String address){
        this.address = address;
        this.sessionId = sessionId;
    }

    public final long sessionId;

    public String address;

    private ServerNative serverNative;

    void setServerNative(int index) {
        this.serverNative = ServerNative.serverNativeList.get(index);
    }

    public void sendDatagram(byte[] message){
        sendDatagram(message,0,message.length);
    }

    public void sendDatagram(byte[] message,long offset,long total){
        this.serverNative.sendDatagramData(sessionId,message,offset,total);
    }

    protected void write(StreamHandle streamHandle,byte[] bytes,long streamId,long offset,long total){
        serverNative.sendStreamData(streamHandle,streamId,bytes,offset,total);
    }

    public void openStream(StreamHandle streamHandle){
        this.serverNative.openStream(sessionId,streamHandle,streamHandle.isBid);
    };

    public abstract void onOpen(Request request);

    public abstract void onDatagram(byte[] data);

    public abstract StreamHandle onStream(boolean isBir);

    public abstract void onSessionFinish();

}
