package com.chapter07.exercise02;
//编写一个Teacher类，要求有name,age,post,salary等属性
//用教授，副教授，讲师类继承Teacher类，并且各个类有工资等级，要求打印各个类的信息
public class HomeWork02 {
    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[4];
        teachers[0] = new Teacher("jack",45,"teacher",12000);
        teachers[1] = new Professor("tom",43,"professor",29999,1.2);
        teachers[2] = new VastProfessor("marry",54,"Vast professor",49832,1.1);
        teachers[3] = new InTeacher("mark",23,"teacher",10000,1.0);
        for (int i = 0; i < teachers.length; i++) {
            System.out.println(teachers[i].introduce());
        }
    }
}
