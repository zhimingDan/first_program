package com.tankgame;

import javax.swing.*;
import java.awt.*;

//坦克需要活动的区域，用面向对象编程的思想，将活动的区域独立出来
public class MyPanel extends JPanel {
    MyTank myTank = null;

    public MyPanel(){
        myTank = new MyTank(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //绘制画板，颜色默认为黑色

        //绘制坦克，专门定义一个绘制坦克的函数
        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);

    }

    /**
     * @param x      表示坦克的起始位置的横坐标
     * @param y      表示坦克起始位置的纵坐标
     * @param g      表示传入一只画笔，因为画笔只有paint函数中才有
     * @param direct 表示坦克的朝向(上下左右)
     * @param type   表示坦克的类型(敌我坦克)
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //绘制不同的坦克，使用不同颜色的画笔
        switch (type) {
            case 0://表示绘制我方坦克,我方坦克使用青色
                g.setColor(Color.cyan);
                break;
            case 1://表示绘制敌方坦克,地方坦克使用黄色
                g.setColor(Color.yellow);
                break;
        }

        //表示坦克的朝向
        switch (direct) {
            case 0: //表示坦克朝上
                g.fill3DRect(x, y, 10, 60, false); //绘制坦克的左轮
                g.fill3DRect(x + 30, y, 10, 60, false); //绘制坦克的右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//绘制坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y - 10);//绘制坦克的炮筒
            default:
                System.out.println("后面再设计");
        }
    }
}
