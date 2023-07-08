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

//        try {
//            // 加载原始图片
//            BufferedImage originalImage = ImageIO.read(new File("E:\\JCTEST\\ssl\\img_1.png"));
//
//            // 创建一个新的空白图片，与原始图片大小相同
//            BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
//
//            // 处理每个像素
//            for (int y = 0; y < originalImage.getHeight(); y++) {
//                for (int x = 0; x < originalImage.getWidth(); x++) {
//                    // 获取当前像素的颜色
//                    Color color = new Color(originalImage.getRGB(x, y));
//
//                    // 检查是否为黑色（RGB值全为0）
//                    if (color.getRed() >= 110 && color.getGreen() >= 110 && color.getBlue() >= 110) {
//                        // 将黑色像素设置为白色（RGB值全为255）
//                        color = Color.WHITE;
//                    }
//
//                    // 在新图片上设置当前像素的颜色
//                    newImage.setRGB(x, y, color.getRGB());
//                }
//            }
//
//            // 保存处理后的图片
//            ImageIO.write(newImage, "jpg", new File("E:\\JCTEST\\ssl\\img2.png"));
//
//            System.out.println("Image processing complete.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
