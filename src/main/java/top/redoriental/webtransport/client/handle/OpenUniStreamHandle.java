package top.redoriental.webtransport.client.handle;

import top.redoriental.webtransport.client.pojo.StreamSession;

public abstract class OpenUniStreamHandle{

    public abstract void onOpen(StreamSession streamSession);

    public abstract void onClose();


}
