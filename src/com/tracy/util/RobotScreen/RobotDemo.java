package com.tracy.util.RobotScreen;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class RobotDemo {

    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private String imageFormat = "png";
    private String fileName = "default";

    public static void main(String[] args) {
        RobotDemo r = new RobotDemo();
        r.snapShot();
        r.setImageFormat("jpeg");
        r.snapShot();
    }

    /**
     * 截图
     */
    public void snapShot() {
        try {
            BufferedImage screen = (new Robot())
                    .createScreenCapture(new Rectangle(0, 0,
                            (int) d.getWidth(), (int) d.getHeight()));
            String name = this.fileName + "." + this.imageFormat;
            File f = new File(name);
            ImageIO.write(screen, this.imageFormat, f);
            System.out.println("截图成功！！！");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("截图失败！！！\n" + e.getMessage());
        }
    }

    /**
     * 设置保存的文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 设置保存的图象的格式
     * 
     * @param imageFormat
     */
    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

}