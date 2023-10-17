package com.tankgame04;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

//坦克大战2.0版本：可以移动坦克，一定要深入体会面向对象编程的思想，要学会去拆解，来降低代码与代码之间的耦合性

public class MyFrame extends JFrame { //定义画框
    public static MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame(){
        System.out.println("请输入 1：重新开始游戏 2：继续上局游戏");
        int key = scanner.nextInt();
        mp = new MyPanel(key); //创建一个画板对象
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,750); //设置画板的大小
        this.addKeyListener(mp);
        this.setVisible(true);   //画框可视化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { //正在关闭窗口的时候进行的处理
                //调用记录成绩的方法
                Recorder.keepRecord();
                //系统正常退出，返回0
                System.exit(0);
            }
        });
    }

}
