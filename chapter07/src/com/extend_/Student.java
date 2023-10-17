package com.extend_;

public class Student { //编写一个父类
    public String name;
    public int age;
    private double score;

    public Student(){
        System.out.println("父类的无参构造器被调用");
    }
    public void setScore(double score) {
        this.score = score;
    }

    public void info(){
        System.out.println("name:" + name + " age:" + age + " score:" + score);
    }
}
