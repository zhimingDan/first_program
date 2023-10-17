package com.tankgame;

//定义一个自己的坦克,然后去继承父类的坦克，拥有坦克的共性
public class MyTank extends Tank { //来继承父类的坦克

    public MyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        myPanel = new MyPanel();
        myPanel.drawTank(getX(),getY(),myPanel.getGraphics(),0,0);
    }
}
