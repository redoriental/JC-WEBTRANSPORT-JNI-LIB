//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.redoriental.webtransport.server.handle;

import top.redoriental.webtransport.server.pojo.ServerSession;

public abstract class ServerSessionHandle {
  public abstract void onOpen(ServerSession serverSession);
  public abstract void onDatagram(byte[] bytes);
  public abstract BidStreamHandle onBidStream();
  public abstract UniStreamHandle onUniStream();
  public abstract void onSessionClose();
}
