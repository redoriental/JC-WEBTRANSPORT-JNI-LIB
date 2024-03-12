package top.redoriental.webtransport.server.handle;

import top.redoriental.webtransport.server.pojo.StreamSession;

public abstract class OpenUniStreamHandle{

    public abstract void onOpen(StreamSession streamSession);

    public abstract void onClose();


}
