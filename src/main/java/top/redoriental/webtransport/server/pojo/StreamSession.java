package top.redoriental.webtransport.server.pojo;

import top.redoriental.webtransport.server.local.ServerNative;

public class StreamSession {

    protected ServerNative serverNative;
    protected long sendStreamId;
    protected boolean isClosed = true;

    protected StreamSession(){}

    public void sendStreamData(byte[] bytes){
        sendStreamData(bytes,0,bytes.length);
    }

    public void sendStreamData(byte[] bytes,long offset,long total){
        if (!isClosed) serverNative.sendStreamData(sendStreamId,bytes,offset,total);
    }

    public void close(){
        this.isClosed = true;
        serverNative.streamSessionClose(this.sendStreamId);
    }
}
