package com.chapter08.innerclass_.anonymous_exercise;

public class AnonymousClassExercise {
    public static void main(String[] args) {
        //当作实参传递，简洁高效
        method(new Interface() {  //这一部分都是实参
            @Override
            public void say() {
                System.out.println("这是一幅画");
            }
        });
    }

    public static void method(Interface interface_){ //创建一个静态方法，并且传入的形参为接口
        interface_.say();  //它的编译类型就是Interface,因此可以直接调用Interface接口中的所有的方法
    }
}

interface Interface{
    public void say();
}
