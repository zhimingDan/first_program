package com.chapter07.exercise06;

public class Teacher extends Person{
    private String word_age;

    public Teacher(String name, char sex, int age, String word_age) {
        super(name, sex, age);
        this.word_age = word_age;
    }
    public String play(){
        return super.getName() + "爱玩象棋";
    }
    public void teach(){
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String toString() {
        return "老师的信息如下" + super.toString() + "\n" + "工龄: " + word_age;
    }
}
