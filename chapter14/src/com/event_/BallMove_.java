package com.event_;

//让小球移动的事件
//利用键盘的输入，控制小球的移动

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove_ extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove_();
    }

    public BallMove_() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //但是这样并不能监听到键盘的事件，需要创建一个键盘的对象，然后将该键盘对象加入到画框中
        //JFrame可以监听键盘事件：监听画板上面发生的键盘事件
        this.addKeyListener(mp);
    }
}

//KeyListener 只是一个事件监听接口，任何类是是实现了事件监听接口，那么这个类成为了一个事件监听器
//这个事件监听接口中有很多的方法，子类重写这些方法，就可以在接收到事件对象的时候，运行自己的业务逻辑

class MyPanel extends JPanel implements KeyListener {

    int x = 10, y = 10;

    @Override
    public void paint(Graphics g) { //重写父类的方法，生成一个画板
        super.paint(g);

        //将小球的左上角坐标设置为变量，这样才能通过改变x,y达到小球移动的效果
        g.fillOval(x, y, 20, 20); //绘制一个小球
    }

    //表示有字符输出从键盘到电脑，该方法就会被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //表示有键被按下，该方法就会被触发
    @Override
    public void keyPressed(KeyEvent e) {

        //e就是一个事件对象，一个事件对象中都携带很多的信息，这里的e只使用了它的按键值的信息

        //e.getKeyCode初始的是该键的ASCLL码值
        //System.out.println((char)e.getKeyCode()+"键被按下");

        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN://向下移动
                y++;
                break;
            case KeyEvent.VK_UP: //向上移动
                y--;
                break;
            case KeyEvent.VK_LEFT://向左移动
                x--;
                break;
            case KeyEvent.VK_RIGHT://向右移动
                x++;
                break;
        }

        //一定要重绘小球,因为重绘小球才能改变小球的位置
        //只有重绘才会刷新
        this.repaint();
    }

    //表示有键被释放，该方法就会被触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
