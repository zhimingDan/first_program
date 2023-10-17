package com.polyarray;

public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public String say(){
        return super.say() + "\t" +salary;
    }
    public void teach(){
        System.out.println("老师 ：" + super.getName() + "正在上课");
    }
}
