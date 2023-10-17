package com.tankgamemyself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//绘制己方的坦克
//继承了JPanel 以及实现了KeyListener接口，这样MyPanel可以作为一个画板以及事件监听器
public class MyPanel extends JPanel implements KeyListener {

    YZF yzf = new YZF(100,100);
    int direct = 0; //默认朝上
    @Override
    public void paint(Graphics g) { //重写父类的方法，获得一只画笔
        super.paint(g);

        drawTank(yzf.getX(),yzf.getY(),g,yzf.getType(),direct);

    }

    //因为需要绘制很多坦克，可以将该方法封装起来，这样直接调用即可
    private void drawTank(int x, int y, Graphics g, int type,int direct) {//必须传入画笔g，这样才能绘制坦克
        switch (type) { //设置画笔的颜色，然后绘制不同颜色的坦克
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.red);
                break;
        }

        switch (direct){
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

        //实时调整坦克的状态
        this.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char ch = (char)e.getKeyCode();
        if(ch == 'W'){
            direct = 0;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
