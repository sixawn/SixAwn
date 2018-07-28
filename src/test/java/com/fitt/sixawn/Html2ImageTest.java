/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn;

import gui.ava.html.image.generator.HtmlImageGenerator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : HTML 转成图片测试
 * @since : 2018/07/16
 */
public class Html2ImageTest {
    public static void main(String[] args) throws Exception {
        generateOutput();
    }

    protected static void generateOutput() throws Exception {

        //load the webpage into the editor
        JEditorPane ed = new JEditorPane(new URL("https://github.com/peterpanBest/elemetUI/blob/master/index.html"));
        //JEditorPane ed = new JEditorPane(new URL("http://www.hefeipet.com/client/chongwuzhishi/shenghuozatan/2012/0220/95.html"));
        ed.setSize(200,200);

        //create a new image
        BufferedImage image = new BufferedImage(ed.getWidth(), ed.getHeight(),
            BufferedImage.TYPE_INT_ARGB);

        //paint the editor onto the image
        SwingUtilities.paintComponent(image.createGraphics(),
            ed,
            new JPanel(),
            0, 0, image.getWidth(), image.getHeight());
        //save the image to file
        ImageIO.write((RenderedImage)image, "png", new File("html2ImageHello.png"));
    }
}
