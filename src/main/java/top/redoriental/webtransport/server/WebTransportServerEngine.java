package top.redoriental.webtransport.server;

import top.redoriental.webtransport.server.handle.SessionHandle;
import top.redoriental.webtransport.server.local.ServerNative;
import top.redoriental.webtransport.server.utils.DLLLoader;
import top.redoriental.webtransport.server.utils.IpUtils;
import top.redoriental.webtransport.server.utils.SystemClassUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WebTransportServerEngine {

    static {
        if (SystemClassUtils.is64bit()&&SystemClassUtils.isWindows()){
            System.load(Objects.requireNonNull(DLLLoader.getLoadPath("CR_WEBTRANSPORT_JNI_LIB.dll",".dll")).replace(".lib",""));
        }else {
            try {
                throw new Exception("系统版本不支持");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    protected String ip;

    protected int port;

    protected String authKey;

    protected String keyPath;

    protected String certPath;

    private long timeout;

    public Map<String,Class<? extends SessionHandle>> pathHandleClassMap = new ConcurrentHashMap<>();

    public ServerNative serverNative;

    public static final Map<Integer, WebTransportServerEngine> portEngineMap = new ConcurrentHashMap<>();


    private WebTransportServerEngine(){
    }

    public static WebTransportServerEngine create(){
        return new WebTransportServerEngine();
    }

    public WebTransportServerEngine setSsl(String key, String crt){
        this.keyPath = key;
        this.certPath = crt;
        return this;
    }

    public WebTransportServerEngine setIpPort(String ip, int port){
        this.ip = ip;
        this.port = port;
        return this;
    }

    public WebTransportServerEngine setAuthKey(String authKey){
        this.authKey = authKey;
        return this;
    }

    public WebTransportServerEngine setTimeout(long timeout){
        this.timeout = timeout;
        return this;
    }

    public WebTransportServerEngine setHandle(String path, Class<? extends SessionHandle> handleC) throws ClassNotFoundException {
        Class.forName(handleC.getName());
        pathHandleClassMap.put(path, handleC);
        return this;
    }

    public int run() throws IOException {
        Set<String> paths = pathHandleClassMap.keySet();
        String[] pathArray = new String[paths.size()];
        Class<?extends SessionHandle>[] handleClassArray = new Class[paths.size()];
        paths.toArray(pathArray);
        for (int i = 0; i < pathArray.length; i++) {
            handleClassArray[i] = pathHandleClassMap.get(pathArray[i]);
        }
        portEngineMap.put(port,this);
        synchronized (ServerNative.serverNativeList){
            this.serverNative = new ServerNative(ServerNative.serverNativeList.size());
            ServerNative.serverNativeList.add(serverNative);
        }
        return serverNative.createServer(authKey,serverNative.index,ip==null? IpUtils.getWlanIPv4Address():ip,port,pathArray,timeout,handleClassArray,keyPath,certPath
                ,DLLLoader.getLoadPath("RQ_WEBTRANSPORT_JNI_LIB.dll",".dll"));
    }

    public void newKey(String newKey){
        serverNative.newKey(newKey);
    }
}
