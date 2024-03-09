package top.redoriental.webtransport.client.utils;

public class SystemClassUtils {
    public static String getOperatingSystem() {
        return System.getProperty("os.name");
    }

    public static boolean isWindows() {
        return getOperatingSystem().toLowerCase().contains("windows");
    }

    public static boolean isLinux() {
        return getOperatingSystem().toLowerCase().contains("linux");
    }

    public static boolean isMac() {
        return getOperatingSystem().toLowerCase().contains("mac");
    }

    public static String getArch() {
        return System.getProperty("os.arch");
    }

    public static boolean is32bit() {
        return getArch().contains("86");
    }

    public static boolean is64bit() {
        return getArch().contains("64");
    }

    public static String getShortName() {
        if (isWindows()) {
            return "windows";
        } else if (isLinux()) {
            return "linux";
        } else if (isMac()) {
            return "mac";
        }
        return "";
    }

    public static String getDynamicLibrarySuffix() {
        switch (getShortName()) {
            case "windows":
                return ".dll";
            case "linux":
                return ".so";
            case "mac":
                return ".dylib";
            default:
                return "";
        }
    }

    public static String getDynamicLibraryPrefix() {
        switch (getShortName()) {
            case "linux":
                return "lib";
            default:
                return "";
        }
    }
}
