package com.tankgamemyself;

//抽象出一个坦克的共性
public class Tank {
    //坦克出生的坐标
    private int x;
    private int y;

    //坦克的型号
    private int type;

    private int direct = 0; //定义坦克的朝向，不然坦克是固定一个方向的

    public Tank(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }
}
