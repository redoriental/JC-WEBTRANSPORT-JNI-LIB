package top.redoriental.webtransport.client.handle;

import top.redoriental.webtransport.client.local.ClientNative;

public abstract class StreamHandle {
    protected long recvStreamId;
    protected boolean isClosed = true;
    public abstract void onData(byte[] bytes);
    public abstract void onClose();

    public void close(){
        ClientNative.recvStreamClose(this.recvStreamId);
    }
}
