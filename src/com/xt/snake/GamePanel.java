package com.xt.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author_name:xiatao
 * @data:2022/3/17
 * @time:21:49
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    public GamePanel() {
        this.init();
        //获取键盘的额监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        this.timer.start();
    }

    //画板， 画界面
    int length;
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    int foodX;
    int foodY;
    int score;

    Random random = new Random();

    String direction;

    boolean isPlaying = false;
    boolean isDead = false;

    Timer timer = new Timer(100, this);

    public void init() {
        this.length = 3;
        this.snakeX[0] = 100;
        this.snakeX[1] = 75;
        this.snakeX[2] = 50;
        this.snakeY[0] = 100;
        this.snakeY[1] = 100;
        this.snakeY[2] = 100;
        this.foodX = 25 + 25 * random.nextInt(34);
        this.foodY = 75 + 25 * random.nextInt(24);
        this.score = 0;

        this.direction = "right";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this, g, 25, 11);
        g.fillRect(25, 75, 850, 600);

        if (direction.equals("right")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("left")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("up")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("down")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        Data.food.paintIcon(this, g, foodX, foodY);
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度:" + this.length, 750, 35);
        g.drawString("分数:" + this.score, 750, 50);

        if (this.isPlaying == false) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
        if (this.isDead == true) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏结束,按下空格开始游戏", 300, 300);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            if (this.isDead) {
                this.isDead = false;
                init();
            }
            this.isPlaying = !this.isPlaying;
            repaint();//刷新界面
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.direction = "right";
        }
        if (code == KeyEvent.VK_LEFT) {
            this.direction = "left";
        }
        if (code == KeyEvent.VK_UP) {
            this.direction = "up";
        }
        if (code == KeyEvent.VK_DOWN) {
            this.direction = "down";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isPlaying && !this.isDead) {
            for (int i = this.length - 1; i > 0; i--) {
                this.snakeX[i] = this.snakeX[i - 1];
                this.snakeY[i] = this.snakeY[i - 1];
            }

            if (this.direction.equals("right")) {
                this.snakeX[0] += 25;
            } else if (this.direction.equals("left")) {
                this.snakeX[0] -= 25;
            } else if (this.direction.equals("up")) {
                this.snakeY[0] -= 25;
            } else if (this.direction.equals("down")) {
                this.snakeY[0] += 25;
            }

            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                this.length++;
                this.score += 10;
                this.foodX = 25 + 25 * random.nextInt(34);
                this.foodY = 75 + 25 * random.nextInt(24);
            }

            this.deadJudge();
            repaint();
        }
        timer.start();
    }

    public void deadJudge() {
        if (this.snakeX[0] > 875 ||
                this.snakeX[0] < 25 ||
                this.snakeY[0] < 75 ||
                this.snakeY[0] > 675) {
            this.isDead = true;
        }
        for (int i = 1; i < this.length; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                this.isDead = true;
            }
        }
    }
}
