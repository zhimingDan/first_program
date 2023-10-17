package com.tankgamemyself;

//定义一个己方坦克，然后继承Tank类中的共性，也拥有自己的个性
public class YZF extends Tank{

    public YZF(int x, int y) {
        super(x, y, 0);  //己方坦克的型号默认不变
    }

}
