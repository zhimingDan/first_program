package com.chapter08.abstractapply_.exercise2;

//抽象类的使用场景2:父类中的抽象方法由子类重写，但是父类中的普通方法依赖于抽象方法，普通方法的实现延迟到子类中去实现
public class AbstractApply2 {
    public static void main(String[] args) {
        SpeedMeter car = new Car(200, 1.5);
        System.out.println(car.getSpeed());
    }
}

abstract class SpeedMeter{//定义一个抽象的父类
    private double turnRate; //转速

    public SpeedMeter(double turnRate) {
        this.turnRate = turnRate;
    }
    //计算车轮的周长，将其定义为抽象方法，因为不同的子类，其车轮的半径不同，因此周长也不同，可以放到子类中去具体实习
    public abstract double calGirth();

    //父类中定义一个普通方法，但是其具体的实现由子类来确定
    public double getSpeed(){
        return calGirth() * turnRate;
    }
}

class Car extends SpeedMeter{
    private double radius;

    public Car(double turnRate, double radius) {
        super(turnRate);
        this.radius = radius;
    }

    @Override
    public double calGirth() {
        return radius * radius * Math.PI;
    }
}
