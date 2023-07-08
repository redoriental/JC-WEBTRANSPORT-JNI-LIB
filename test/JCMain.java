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
                .setAuthKey("your key")
                .setIpPort("127.0.0.1",10001)
                .setHandle("/test",JcHandle.class)
                .setTimeout(40000)
                .setSsl("E:\\JCTEST\\ssl\\redoriental.top.key","E:\\JCTEST\\ssl\\redoriental.top_bundle.crt")
                .run();


    }
}
