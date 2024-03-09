package top.redoriental.webtransport.client.handle;

import top.redoriental.webtransport.client.pojo.StreamSession;

public abstract class BidStreamHandle extends StreamHandle{
    public abstract void onOpen(StreamSession session);

}
