package top.redoriental.webtransport.server.local;


import top.redoriental.webtransport.server.handle.StreamHandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.redoriental.webtransport.server.handle.StreamHandle;

public class ServerNative {

    public ServerNative(int index){
        this.index = index;
    }

    public final static List<ServerNative> serverNativeList = new ArrayList<>();

    public int index;

    public native int createServer(String authKey,int index,String ip, int port, String[] paths,long timeout, Class[] classArray, String keyFile, String certFile, String dllPath);

    public native int sendStreamData(StreamHandle streamHandle, long stream_id, byte[] bytes, long offset, long total);

    public native int sendDatagramData(long sessionId, byte[] bytes, long offset, long total);

    public native void openStream(long sessionId,StreamHandle streamHandle,boolean isBid);

    public native void newKey(String newKey);

}
