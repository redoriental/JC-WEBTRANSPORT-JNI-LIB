package top.redoriental.webtransport.server.local;

import java.util.List;
import java.util.Vector;

import top.redoriental.webtransport.server.handle.BidStreamHandle;
import top.redoriental.webtransport.server.handle.OpenUniStreamHandle;
import top.redoriental.webtransport.server.handle.ServerSessionHandle;
import top.redoriental.webtransport.server.handle.StreamHandle;

public class ServerNative {
  public native int init();
  public native void setRouteClass(String path, Class<? extends ServerSessionHandle> serverSessionHandleClass);
  public native int createServer(String ip, int port, long timeout, String keyPath, String certPath);
  public native int sendStreamData(long sendStreamId, byte[] bytes, long offset, long total);
  public native int sendDatagramData(long sessionId, byte[] bytes, long offset, long total);
  public native void openUniStream(long sessionId, OpenUniStreamHandle openUniStreamHandle);
  public native void openBidStream(long sessionId, BidStreamHandle bidStreamHandle);
  public native void serverSessionClose(long sessionId);
  public native void streamSessionClose(long sendStreamId);
  public native void recvStreamClose(long recvStreamId);
}
