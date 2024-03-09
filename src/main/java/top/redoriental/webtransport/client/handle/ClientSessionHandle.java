//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.redoriental.webtransport.client.handle;

import top.redoriental.webtransport.client.pojo.ClientSession;

public abstract class ClientSessionHandle {
  public abstract void onOpen(ClientSession clientSession);
  public abstract void onDatagram(byte[] bytes);
  public abstract BidStreamHandle onBidStream();
  public abstract UniStreamHandle onUniStream();
  public abstract void onSessionClose();
}
