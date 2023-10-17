package com.chapter08.interface_exercise;

public class Text01 {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        System.out.println(aaa.m); //实例化的对象是可以访问静态属性的,相当于子类的实例调用父类的静态属性，是可以的
        System.out.println(Interface01.m);//接口名.变量名 --->这是访问接口的标准的方式
        System.out.println(AAA.m);//相当于子类的类名直接调用父类的静态变量
    }
}
