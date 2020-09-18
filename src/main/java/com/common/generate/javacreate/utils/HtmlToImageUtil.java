package com.common.generate.javacreate.utils;

import gui.ava.html.image.generator.HtmlImageGenerator;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * @author xialei
 * @date 2020/9/2 10:47
 */
public class HtmlToImageUtil {

    public static void toImage(String html, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            OutputStream out = response.getOutputStream();
            HtmlImageGenerator imageGenerator = new HtmlImageGenerator();

            imageGenerator.loadHtml(html);//也可以根据html url引用 loadUrl的方式加载
            BufferedImage bufferedImage = imageGenerator.getBufferedImage();
            Graphics2D g = bufferedImage.createGraphics();
            Font font = new Font("Microsoft YaHei", Font.BOLD, 12);
            g.setFont(font);
            Thread.sleep(10000); //有时会有加载图片延迟，因此这里设置下延时

            ImageIO.write(bufferedImage, "png", out);//输出图片 图片泛红(1)jpg改成png即可
            out.close();
            /*imageGenerator.getBufferedImage();*/
            //Thread.sleep(2000);
            /* String imageName = "C:\\"+ UUID.randomUUID().toString() + ".png";*/
            /*imageGenerator.saveAsImage(imageName);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveImage(String html, HttpServletResponse response) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        imageGenerator.loadHtml(html);
        imageGenerator.getBufferedImage();
        imageGenerator.saveAsImage("d:/hello-world.png");
        imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
    }
}
