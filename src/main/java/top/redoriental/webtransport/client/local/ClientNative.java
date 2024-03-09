//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.redoriental.webtransport.client.local;

import top.redoriental.webtransport.client.handle.BidStreamHandle;
import top.redoriental.webtransport.client.handle.ConnectStatusHandle;
import top.redoriental.webtransport.client.handle.OpenUniStreamHandle;
import top.redoriental.webtransport.client.pojo.StreamSession;

public class ClientNative {
    public static native void init();
    public static native void createClient(String url, ConnectStatusHandle connectStatusHandle, boolean isAsync);
    public static native int sendStreamData(long sendStreamId, byte[] bytes, long offset, long total);
    public static native int sendDatagramData(long sessionId, byte[] bytes, long offset, long total);
    public static native void openUniStream(long sessionId, OpenUniStreamHandle openUniStreamHandle);
    public static native void openBidStream(long sessionId, BidStreamHandle bidStreamHandle);
    public static native void clientSessionClose(long sessionId);
    public static native void streamSessionClose(long sendStreamId);
    public static native void recvStreamClose(long recvStreamId);
}
