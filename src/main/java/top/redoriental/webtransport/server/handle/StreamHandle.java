package top.redoriental.webtransport.server.handle;

import top.redoriental.webtransport.server.local.ServerNative;

public abstract class StreamHandle {
    protected long recvStreamId;
    protected ServerNative serverNative;
    protected boolean isClosed = true;
    public abstract void onData(byte[] bytes);
    public abstract void onClose();

    public void close(){
        serverNative.recvStreamClose(this.recvStreamId);
    }
}
