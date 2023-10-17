package com.tankgame03;

//一定要体现面向对象的思想，因为有很多的坦克，而且各个坦克的类型也各不相同，因此可以抽象
//出一个父类坦克，让所有的坦克去继承这个父类的坦克
public class Tank {
    private int x;
    private int y;

    public boolean isLive = true;
    private int direct; //默认朝向为向上

    Fire fires = null;
    private int speed = 5; //将坦克的速度初始化为5

    public void moveUp() { //向上移动
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void improveSpeed() {
        speed++;
    }

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void shotEnemyTank() { //设计敌人坦克的函数
        //根据坦克的方向，来决定子弹的方向
        switch (direct) {
            case 0: //表示向上
                fires = new Fire(x + 20, y - 10, direct);
                break;
            case 1: //表示向右
                fires = new Fire(x + 70, y + 20, direct);
                break;
            case 2: //表示向下
                fires = new Fire(x + 20, y + 70, direct);
                break;
            case 3: //表示向左
                fires = new Fire(x - 10, y + 20, direct);
                break;
        }
        fires.start(); //启动线程
    }
}
