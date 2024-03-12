package top.redoriental.webtransport.server.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DllUtils {
    public static String getLoadPath(String dll,String suffix){
        try {
            InputStream in = DllUtils.class.getClassLoader().getResourceAsStream(dll);
            File fileOut = File.createTempFile("libMyNativeLibrary", suffix);
            FileOutputStream out = new FileOutputStream(fileOut);

            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }
            out.close();
            in.close();
            return fileOut.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
