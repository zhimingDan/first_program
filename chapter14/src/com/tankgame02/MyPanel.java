package com.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克需要活动的区域，用面向对象编程的思想，将活动的区域独立出来
public class MyPanel extends JPanel implements KeyListener {

    MyTank myTank = null;
    Graphics graphics = null;
    //Tank[] tank = new Tank[5]; //定义一个多态数组
    //最好是定义一个集合Vector,因为后面坦克有多线程
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int direct; //默认朝向为向上

    public MyPanel() {
        myTank = new MyTank(100, 100);
        int enemyTankNum = 3;
        for (int i = 0; i < enemyTankNum; i++) {
            enemyTanks.add(new EnemyTank(100 * (i + 1), 0));
        }
    }

    @Override
    public void paint(Graphics g) { //每次重新调用的是paint函数
        super.paint(g);
        graphics = g;
        g.fillRect(0, 0, 1000, 750); //绘制画板，颜色默认为黑色


        drawTank(myTank.getX(), myTank.getY(), g, direct, 0);


        //老师绘制坦克的函数：
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, direct, 1);
        }
    }

    /**
     * @param x      表示坦克的起始位置的横坐标
     * @param y      表示坦克起始位置的纵坐标
     * @param g      表示传入一只画笔，因为画笔只有paint函数中才有
     * @param direct 表示坦克的朝向(上下左右)
     * @param type   表示坦克的类型(敌我坦克)
     *
     *将绘制坦克的函数直接做成静态的static的
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

        //表示坦克的朝向(0:向上 1:向右 2:向下 3:向左 )
        switch (direct) {
            case 0: //表示坦克朝上
                g.fill3DRect(x, y, 10, 60, false); //绘制坦克的左轮
                g.fill3DRect(x + 30, y, 10, 60, false); //绘制坦克的右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//绘制坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y - 10);//绘制坦克的炮筒
                break;
            case 1://表示坦克朝右，实际上思想不变，还是以左上角的(x,y)为基准进行变化
                g.fill3DRect(x, y, 60, 10, false); //绘制坦克的上轮
                g.fill3DRect(x, y + 30, 60, 10, false); //绘制坦克的下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//绘制坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x + 70, y + 20);//绘制坦克的炮筒
                break;
            case 2: //表示坦克朝下，实际上对于这种对称的坦克，只要指向炮筒的指向改变一下行了
                g.fill3DRect(x, y, 10, 60, false); //绘制坦克的左轮
                g.fill3DRect(x + 30, y, 10, 60, false); //绘制坦克的右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//绘制坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 70);//绘制坦克的炮筒
                break;
            case 3://表示坦克朝左，实际上对于这种对称的坦克，只要指向炮筒的指向改变一下行了
                g.fill3DRect(x, y, 60, 10, false); //绘制坦克的上轮
                g.fill3DRect(x, y + 30, 60, 10, false); //绘制坦克的下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//绘制坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x - 10, y + 20);//绘制坦克的炮筒
                break;
            default: //如果数值不是这个范围，那么这个坦克保持原样不动
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char ch = (char) e.getKeyCode();
        //System.out.println(e.getKeyCode()+"键被按下" + "--->" + ch);
        switch (ch) {
            case 'W':
                direct = 0;
                //这样虽然可以实现坦克的移动，但是还是感觉有点low，最好还是自己封装成方法
                //myTank.setY(myTank.getY() - 2);
                myTank.moveUp();
                break;
            case 'D':
                direct = 1;
                //myTank.setX(myTank.getX() + 2);
                myTank.moveRight();
                break;
            case 'S':
                direct = 2;
                //myTank.setY(myTank.getY() + 2);
                myTank.moveDown();
                break;
            case 'A':
                direct = 3;
                //myTank.setX(myTank.getX() - 2);
                myTank.moveLeft();
                break;
            case 'L':
                myTank.improveSpeed();break;
            case'J':
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
