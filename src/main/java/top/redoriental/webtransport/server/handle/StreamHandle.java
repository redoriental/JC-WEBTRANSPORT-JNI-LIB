package top.redoriental.webtransport.server.handle;

public abstract class StreamHandle {

    public StreamHandle(boolean isBid,SessionHandle sessionHandle){
        this.isBid = isBid;
        this.sessionHandle = sessionHandle;
    }

    public final SessionHandle sessionHandle;

    public final boolean isBid;
    long streamId;

    public long getStreamId() {
        return streamId;
    }

    public void write(byte[] bytes, long streamId){
        write(bytes,streamId,0,bytes.length);
    }

    public void write(byte[] bytes,long streamId,long offset,long total){
        this.sessionHandle.write(this,bytes,streamId,offset,total);
    }

    public abstract void onOpen(long streamId);

    public abstract void onStreamData(byte[] bytes);

    public abstract void onStreamFinish();

}
