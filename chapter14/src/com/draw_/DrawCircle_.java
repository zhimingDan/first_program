package com.draw_;

import javax.swing.*;
import java.awt.*;

/*
画一个图形的步骤：
1.首先创建一个画板类继承JPanel，然后重写JPanel的paint方法，此时这个类就相当于一个画板，并且画板中有个画笔
2.在paint()方法中绘制自己想要绘制的图片后
3.然后创建一个画框类继承JFrame,此时这个类就相当于一个画框，只要用add()方法，把画板加入，然后设置画框的大小以及
  可视化问题，即可在画框中显示自己的绘画

 */

//利用java绘制一个圆
//有了画板没有绘画的地方也不行，让一个类继承JFrame，那么这个类就相当于一个画框
public class DrawCircle_ extends JFrame{  //JFrame对应窗口，可以理解为一个画框

    //定义一个画板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle_();
    }

    public DrawCircle_(){ //这里的函数实际上是在搭建画板的位置的平台，没有画框，画板也无从显示
        //初始化画板
        mp = new MyPanel();

        //一下这些this的方法，实际上都是调用父类JFrame中的方法来实现画板在画框上的操作
        //把画板放到窗口中(画框),实际上调用这个方法的时候，就已经完成了绘画的操作
        this.add(mp);
        //设置窗口的大小
        this.setSize(400,300);
        //当点击窗口的x时，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口的可视化
        this.setVisible(true);
    }

}

//定义一个MyPanel类，继承JPanel类，画图像就在画板上面画(JPanel可以说就是一个创建画板的类，里面有创建画板的方法)
class MyPanel extends JPanel{

    //说明：1.MyPanel继承了JPanel，因此MyPanel的对象就是一个画板
    //2.Graphics g 可以把 g 理解为一支画笔
    //3.有了画笔g,才能有画画的方法：Graphics 中提供了很多的画图方法


    @Override
    public void paint(Graphics g) {  //绘图方法
        super.paint(g); //调用父类的方法完成初始化

        //System.out.println("paint方法被调用了~~");

        //g.drawOval(10,10,200,200);  //绘制一个圆

        //获取一个图片资源   这个图片名前面加的/表示从当前输出目录中去寻找图片
        //前面都是固定写法
         //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/jiazai2.png"));
         //g.drawImage(image,10,10,872,860,this); //this表示在当前画板中去绘制

        //画字符串：drawString()
        //步骤：1.设置字体的颜色，实际上就是设置画笔的颜色
        g.setColor(Color.blue);
        //2.设置字体的样式
        g.setFont(new Font("宋体",Font.BOLD,50));  //setFont里面传入的是一个Font对象
        //Font对象中设置了字体的样式：宋体，然后为粗体，字体的宽度为50

        //3.在画板中画出字符串：
        g.drawString("hello",100,100);//这里的起始坐标为左下角
    }
}
