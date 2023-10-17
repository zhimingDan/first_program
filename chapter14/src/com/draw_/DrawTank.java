package com.draw_;

//要求:绘制一辆坦克

import javax.swing.*;
import java.awt.*;

public class DrawTank extends JFrame{
    private MyPanel_Tank mp = null ;

    public static void main(String[] args) {
        new DrawTank();
    }

    public DrawTank(){
        mp = new MyPanel_Tank();
        this.add(mp);
        this.setVisible(true);
        this.setSize(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MyPanel_Tank extends JPanel { //定义一个画板


    @Override
    public void paint(Graphics g) { //重写父类的画板的方法
        super.paint(g);

        g.setColor(Color.blue); //设置颜色为蓝色
        g.drawRect(40,40,10,40); //绘制坦克的左组轮
        g.fillRect(40,40,10,40);
        //以上这两个函数，实际上可以直接用一个画矩形的函数完成，不用先画轮廓，然后填充
        g.drawRect(70,40,10,40); //绘制坦克的右组轮
        g.fillRect(70,40,10,40); //填充坦克的颜色

        g.drawOval(50,50,20,20);
        g.fillOval(50,50,20,20);

        g.drawLine(60,60,60,20);
    }
}
