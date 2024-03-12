package top.redoriental.webtransport.server.handle;

import top.redoriental.webtransport.server.pojo.StreamSession;

public abstract class BidStreamHandle extends StreamHandle{
    public abstract void onOpen(StreamSession session);

}
