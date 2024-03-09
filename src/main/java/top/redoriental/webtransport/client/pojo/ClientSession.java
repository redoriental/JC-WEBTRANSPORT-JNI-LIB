package top.redoriental.webtransport.client.pojo;

import top.redoriental.webtransport.client.handle.BidStreamHandle;
import top.redoriental.webtransport.client.handle.OpenUniStreamHandle;
import top.redoriental.webtransport.client.local.ClientNative;

public class ClientSession {
    protected long sessionId;
    protected boolean isClosed = true;

    protected ClientSession(){}

    public void sendDatagram(byte[] message) throws Exception {

        this.sendDatagram(message, 0L, (long)message.length);
    }
    public void sendDatagram(byte[] message, long offset, long total)throws Exception{
        check();
        ClientNative.sendDatagramData(this.sessionId, message, offset, total);
    }
    private void check() throws Exception {
        if (isClosed){throw new Exception("The session has been closed");}
    }
    public void openUniStream(OpenUniStreamHandle openUniStreamHandle) throws Exception {
        check();
        ClientNative.openUniStream(this.sessionId,openUniStreamHandle);
    }

    public void openBidStream(BidStreamHandle bidStreamHandle) throws Exception {
        check();
        ClientNative.openBidStream(this.sessionId,bidStreamHandle);
    }

    public void close(){
        this.isClosed = true;
        ClientNative.clientSessionClose(this.sessionId);
    }

}
