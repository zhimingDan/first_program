package com.chapter08.abstractapply_.exercise1;

//抽象类的应用方式1：抽象类作为父类，由子类去实现父类中抽象的方法，父类中的普通方法和抽象方法没有任何关联
public class AbstractApply01 {
    public static void main(String[] args) {
        //抽象类把多态体现的淋漓尽致，因为抽象类不能被实例化，只能被继承，抽象类就是一个模板
        Shape triangle = new Triangle("白色", 2, 3, 4); //父类的引用指向子类的对象
        System.out.println(triangle.calPerimeter());
        System.out.println(triangle.getType());
    }
}


abstract class Shape{ //定义一个抽象的父类方法
    private String color;

    public Shape(String color) { //生成一个构造函数
        this.color = color;
    }

    //计算图形的周长，由子类来实现
    public abstract double calPerimeter();

    //得到图像的形状
    public abstract String getType();

    public String getColor() {
        return color;
    }

}

class Triangle extends Shape{

    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color); //给父类的构造器进行初始化
        if(a >= b + c || b >= a + c || c >= b + a) {
            System.out.println("三角形必须满足两边之和大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "颜色：" + super.getColor() + "  形状：三角形";
    }
}