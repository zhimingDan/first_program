package com.chapter08.block_;

//分析一下代码的输出结果
public class BlockExercise {
    public static void main(String[] args) {
        TestA a = new TestA();
    }
}

class TestA{
    TestB b1 = new TestB();  //相当于普通属性的初始化
    //TestB static B2 = new TestB(); //这样的语法是错误的
    static TestB b2 = new TestB(); //相当于静态属性初始化

    static {
        System.out.println("static 代码块被执行");
        if(b2 == null){
            System.out.println("B2 is null");
        }
    }

    TestA(){
        System.out.println("TestA的构造器被执行");
    }

}

class TestB{
    TestB() {
        System.out.println("默认无参构造器被调用");
    }
    TestB(String s) {
        System.out.println(s);
    }
}
