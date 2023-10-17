package com.chapter08.abstract_exercise;

//理解抽象类的设计模式-->模板设计模式

public class TestTemple {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        BBB bbb = new BBB();
        aaa.calculate(); //这里也是有动态绑定机制的
        bbb.calculate();
    }
}
