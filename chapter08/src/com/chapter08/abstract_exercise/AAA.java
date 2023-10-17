package com.chapter08.abstract_exercise;

public class AAA extends Temple{
    @Override
    public void job(){ //把父类的抽象方法当做一个模板，子类中重写父类中的抽象方法
        long num = 0;
        for (int i = 1; i <= 10000; i++) {
            num += i;
        }
        System.out.println("AAA类中的job方法被调用");
    }
}
