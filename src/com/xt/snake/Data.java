package com.xt.snake;

import javax.swing.*;
import java.net.URL;

/**
 * @author_name:xiatao
 * @data:2022/3/17
 * @time:21:53
 */
public class Data {
    //URL定位图片的地址
    public static URL headerUrl = Data.class.getResource("/static/header.png");
    //ImageIcon找到图片
    public static ImageIcon header = new ImageIcon(headerUrl);

    public static URL upUrl = Data.class.getResource("/static/up.png");
    public static URL downUrl = Data.class.getResource("/static/down.png");
    public static URL rightUrl = Data.class.getResource("/static/right.png");
    public static URL leftUrl = Data.class.getResource("/static/left.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);

    public static URL foodUrl = Data.class.getResource("/static/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);

    public static URL bodyUrl = Data.class.getResource("/static/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
}
