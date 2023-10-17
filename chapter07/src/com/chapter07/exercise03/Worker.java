package com.chapter07.exercise03;

public class Worker {
    private String name;
    private double daySal;
    private int day;

    public Worker(String name, double daySal, int day) {
        this.name = name;
        this.daySal = daySal;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void print(){
        System.out.println("name:" + this.name + "\t工资:" + this.day * this.daySal);
    }
}

class Employer extends Worker{
    private double level;

    public Employer(String name, double daySal, int day, double level) {
        super(name, daySal, day);
        this.level = level;
    }

    public void print(){
        System.out.println("部门经理的信息如下:");
        System.out.println("name:" + this.getName() + "\t工资:" + (this.getDay() * this.getDaySal() * this.level + 1000));
    }
}

class Employee extends Worker{
    private double level;

    public Employee(String name, double daySal, int day, double level) {
        super(name, daySal, day);
        this.level = level;
    }

    public void print(){
        //普通员工可以直接调用父类的打印方法
        System.out.println("普通员工的信息如下:");
        System.out.println("name:" + this.getName() + "\t工资:" + this.getDay() * this.getDaySal() * this.level);
    }
}


