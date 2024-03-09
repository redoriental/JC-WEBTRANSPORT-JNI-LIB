package top.redoriental.webtransport.client.pojo;

import top.redoriental.webtransport.client.local.ClientNative;

public class StreamSession {
    protected long sendStreamId;
    protected boolean isClosed = true;

    public void sendStreamData(byte[] bytes){
        sendStreamData(bytes,0,bytes.length);
    }

    public void sendStreamData(byte[] bytes,long offset,long total){
        if (!isClosed) ClientNative.sendStreamData(sendStreamId,bytes,offset,total);
    }

    public void close(){
        this.isClosed = true;
        ClientNative.streamSessionClose(this.sendStreamId);
    }


}
