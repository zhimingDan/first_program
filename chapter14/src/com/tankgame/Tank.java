package com.tankgame;

//一定要体现面向对象的思想，因为有很多的坦克，而且各个坦克的类型也各不相同，因此可以抽象
//出一个父类坦克，让所有的坦克去继承这个父类的坦克

/*  一开始就要去构思，如果我要做一个坦克大战，里面有什么？
    首先是坦克，那么坦克有哪些种呢？能不能找到各个坦克的共性，分离出一个父类。然后找到各个坦克的个性，定义不同的子类

    对老师编写程序的解读：
    1.各个坦克都有出生位置(也就是绘制坦克模型的起始点)，因此可以抽象一个父类出来，在其中定义x,y变量来表示
    不同的坦克的出生地的不同
    2.各个坦克都有颜色，炮筒的朝向，能够发射炮弹，血条等，这些均是坦克的共性，因此可以在父类中定义这些属性
 */
public class Tank extends Thread{
    private int x;
    private int y;

    MyPanel myPanel;
    //创建一个构造器，提供setter和getter方法
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public void run() {

    }
}
