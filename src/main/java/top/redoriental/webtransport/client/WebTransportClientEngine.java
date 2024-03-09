//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.redoriental.webtransport.client;

import top.redoriental.webtransport.client.handle.ConnectStatusHandle;
import top.redoriental.webtransport.client.local.ClientNative;
import top.redoriental.webtransport.client.utils.DllUtils;
import top.redoriental.webtransport.client.utils.IpUtils;
import top.redoriental.webtransport.client.utils.SystemClassUtils;

public class WebTransportClientEngine {

    public static boolean createClient(String url, ConnectStatusHandle connectStatusHandle) {
        if (!IpUtils.isValidURL(url)) {
            return false;
        } else {
            ClientNative.createClient(url, connectStatusHandle, true);
            return true;
        }
    }

    static {
        String dllPath = DllUtils.getLoadPath("RQ_WEBTRANSPORT_CLIENT_JNI_LIB.dll",".dll");
        if (SystemClassUtils.is64bit() && SystemClassUtils.isWindows()) {
            System.load(dllPath);
        } else {
            throw new RuntimeException("不支持该系统");
        }
        ClientNative.init();
    }
}
