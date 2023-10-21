package com.chapter08.block_;

//分析一下代码的输出结果
// 心里一定要时刻牢记代码执行的先后顺序
public class BlockExercise {
    public static void main(String[] args) {
        TestA a = new TestA();
        // A类被实例化(类加载)
    }
}

// 首先，因为TestA类被实例化(类加载)，此时判断TestA类中的父类是否有静态变量和静态代码块，先初始化父类的
// 然后回到TestA本类中来执行静态变量和静态代码块
// 然后执行普通变量和普通代码块
// 最后再执行父类的构造器然后是子类的构造器

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
