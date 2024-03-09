package top.redoriental.webtransport.client.utils;

import java.net.*;
import java.util.Enumeration;

public class IpUtils {

    public static String getWlanIPv4Address() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (address.getAddress().length == 4 && isWlanInterface(networkInterface)) {
                            return address.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "127.0.0.1";
    }

    public static boolean isWlanInterface(NetworkInterface networkInterface) {
        return networkInterface.getDisplayName().toLowerCase().contains("wlan");
    }
    public static boolean isValidURL(String urlString) {
        try {
            // 尝试解析 URL
            new URL(urlString);
            return true; // 如果成功解析，URL 格式正确
        } catch (MalformedURLException e) {
            // URL 格式不正确
            return false;
        }
    }
}
