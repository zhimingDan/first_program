package com.tankgame02;

//一定要体现面向对象的思想，因为有很多的坦克，而且各个坦克的类型也各不相同，因此可以抽象
//出一个父类坦克，让所有的坦克去继承这个父类的坦克
public class Tank {
    private int x;
    private int y;


    private int speed = 1; //将坦克的速度初始化为1

    public void moveUp(){ //向上移动
        y -= speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }
    public void moveRight(){
        x += speed;
    }

    public void improveSpeed(){
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
}
