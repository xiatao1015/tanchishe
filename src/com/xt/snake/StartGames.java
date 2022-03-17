package com.xt.snake;

import javax.swing.*;

/**
 * @author_name:xiatao
 * @data:2022/3/17
 * @time:21:43
 */
public class StartGames {
    public static void main(String[] args) {
        //1.绘制静态窗口
        JFrame jFrame = new JFrame("贪吃蛇");
        jFrame.setBounds(10,10,900,720);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(new GamePanel());

        jFrame.setVisible(true);
    }
}
