package top.redoriental.webtransport.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import top.redoriental.webtransport.server.handle.ServerSessionHandle;
import top.redoriental.webtransport.server.local.ServerNative;
import top.redoriental.webtransport.server.utils.DllUtils;
import top.redoriental.webtransport.server.utils.IpUtils;
import top.redoriental.webtransport.server.utils.SystemClassUtils;

public class WebTransportServerEngine {
  protected String ip;

  protected int port;

  protected String keyPath;

  protected String certPath;

  private long timeout;

  static {
    String dllPath = DllUtils.getLoadPath("RQ_WEBTRANSPORT_SERVER_JNI_LIB.dll",".dll");
    if (SystemClassUtils.is64bit() && SystemClassUtils.isWindows()) {
//      System.load("E:\\c\\RQ-WEBTRANSPORT-SERVER-JNI-LIB\\target\\release\\RQ_WEBTRANSPORT_SERVER_JNI_LIB.dll");
      System.load(dllPath);
    } else {
      throw new RuntimeException("不支持该系统");
    }
  }

  ServerNative serverNative;

  private WebTransportServerEngine() {
    this.serverNative = new ServerNative();
    this.serverNative.init();
  }

  public static WebTransportServerEngine create() {
    return new WebTransportServerEngine();
  }

  public WebTransportServerEngine setSsl(String key, String crt) {
    this.keyPath = key;
    this.certPath = crt;
    return this;
  }

  public WebTransportServerEngine setIpPort(String ip, int port) {
    this.ip = ip;
    this.port = port;
    return this;
  }

  public WebTransportServerEngine setTimeout(long timeout) {
    this.timeout = timeout;
    return this;
  }

  public WebTransportServerEngine setHandle(String path, Class<? extends ServerSessionHandle> handleC) throws ClassNotFoundException {
    this.serverNative.setRouteClass(path,handleC);
//    Class.forName(handleC.getName());
//    this.pathHandleClassMap.put(path, handleC);
    return this;
  }

  public int run() {
    return this.serverNative.createServer((this.ip == null) ? IpUtils.getWlanIPv4Address() : this.ip, this.port, this.timeout, this.keyPath, this.certPath);
  }
}
