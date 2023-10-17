package com.chapter08.abstract_exercise;

public class BBB extends Temple{
    @Override
    public void job(){ //重写父类的方法
        long sum = 0;
        for (int i = 1; i <= 20000; i++) {
            sum *= i;
        }
        System.out.println("BBB中的方法被调用");
    }
}
