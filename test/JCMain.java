package top.test;

import top.redoriental.webtransport.server.WebTransportServerEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JCMain {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        WebTransportServerEngine
                .create()
                .setAuthKey("iHvuwuUnIM5/+AW18uTGeq0cnCII05dzuVMHaUCqtv49SxVEyIoS4X+QqE12UasxMyQHu9TqnTAXKlZ7z5+p1d0JPUidntpc50KSQD7WRVM=")
                .setIpPort("127.0.0.1",10001)
                .setHandle("/test",JcHandle.class)
                .setTimeout(40000)
                .setSsl("E:\\JCTEST\\ssl\\redoriental.top.key","E:\\JCTEST\\ssl\\redoriental.top_bundle.crt")
                .run();


    }
}
