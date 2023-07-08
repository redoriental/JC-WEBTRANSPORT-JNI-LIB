package top.redoriental.webtransport.server.utils;

import java.net.*;
import java.util.*;

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

}
