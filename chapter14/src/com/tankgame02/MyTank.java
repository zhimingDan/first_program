package com.tankgame02;

//定义一个自己的坦克
public class MyTank extends Tank implements Runnable{ //来继承父类的坦克

    public MyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {

    }
}
