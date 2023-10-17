package com.tankgame;

import javax.swing.*;

//坦克大战1.0版本，一定要深入体会面向对象编程的思想，要学会去拆解，来降低代码与代码之间的耦合性

public class MyFrame extends JFrame { //定义画框
    MyPanel mp = null;

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame(){
        mp = new MyPanel(); //创建一个画板对象
        this.add(mp);
        this.setSize(1000,750); //设置画板的大小
        this.setVisible(true);   //画框可视化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
