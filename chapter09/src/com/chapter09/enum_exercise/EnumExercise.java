package com.chapter09.enum_exercise;

//enum类的练习：
//声明一个Week枚举类，其中包含星期一到星期日的定义
//使用values方法返回所有的枚举数组，并遍历
public class EnumExercise {
    public static void main(String[] args) {
        //得到枚举类Week中所有的常量名
        Week[] values = Week.values();
        System.out.println("所有星期的信息如下");
        for(Week num : values){ //使用增强for循环
            //如果这里不是调用getName方法，那么则是默认调用各个枚举常量的toString方法
            System.out.println(num.getName());
            //System.out.println(num);
        }
    }
}

enum Week{
    //定义枚举常量,这些枚举常量其实就相当于对象的实例
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),
    THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期天");

    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}