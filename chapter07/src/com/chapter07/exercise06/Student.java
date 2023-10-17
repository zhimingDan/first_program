package com.chapter07.exercise06;

public class Student extends Person{
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
    public String play(){
        return super.getName() + "爱玩足球";
    }
    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String toString() {
        return "学生的信息如下" + super.toString() + "\n" + "学号: " + stu_id;
    }
}
