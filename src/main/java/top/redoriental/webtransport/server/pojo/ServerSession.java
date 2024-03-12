package top.redoriental.webtransport.server.pojo;

import top.redoriental.webtransport.server.handle.BidStreamHandle;
import top.redoriental.webtransport.server.handle.OpenUniStreamHandle;
import top.redoriental.webtransport.server.local.ServerNative;

public class ServerSession {

    protected ServerNative serverNative;
    protected long sessionId;
    protected boolean isClosed = true;

    protected Request request = new Request();

    protected ServerSession(){
    }

    public void sendDatagram(byte[] message) throws Exception {

        this.sendDatagram(message, 0L, (long)message.length);
    }
    public void sendDatagram(byte[] message, long offset, long total)throws Exception{
        check();
        serverNative.sendDatagramData(this.sessionId, message, offset, total);
    }
    private void check() throws Exception {
        if (isClosed){throw new Exception("The session has been closed");}
    }
    public void openUniStream(OpenUniStreamHandle openUniStreamHandle) throws Exception {
        check();
        serverNative.openUniStream(this.sessionId,openUniStreamHandle);
    }

    public void openBidStream(BidStreamHandle bidStreamHandle) throws Exception {
        check();
        serverNative.openBidStream(this.sessionId,bidStreamHandle);
    }

    public void close(){
        this.isClosed = true;
        serverNative.serverSessionClose(this.sessionId);
    }

    protected void putHeader(String key,String value){
        request.requestHeaders.put(key,value);
    }

    protected void setRequestRemoteAddress(String remoteAddress){
        request.remoteAddress = remoteAddress;
    }

    protected void setRequestRoute(String route){
        request.route = route;
    }

    protected void setRequestAuthority(String authority){
        request.authority = authority;
    }

    @Override
    public String toString() {
        return "ServerSession{" +
                "serverNative=" + serverNative +
                ", sessionId=" + sessionId +
                ", isClosed=" + isClosed +
                ", request=" + request +
                '}';
    }
}
