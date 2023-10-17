package com.chapter08.homework.second_;

/*  编程题：
    1.动物类Animal中包含了抽象方法shout();
    2.Cat类继承了Animal，并实现了方法shout,打印“猫会喵喵叫...”
    3.Dog类继承了Animal，并实现了方法shout,打印“狗会汪汪叫...”
    4.在测试类中，实例化Animal cat = new Cat();并调用cat的shout方法
    5.在测试类中，实例化Animal dog = new Dog();并调用dog的shout方法
 */

//可以清楚的对比出：采用匿名内部类和采用普通方法去继承的区别
//1.如果你想可能会一直使用某个类的实例化对象，那么就采用普通的方法去继承
//2.如果你仅仅只想使用一次某个类去调用抽象类(接口)中的方法，那么就采用匿名内部类
public class HomeWork {
    public static void main(String[] args) {
//        Animal cat = new Cat();
//        Animal dog = new Dog();
//        cat.shout();
//        dog.shout();

        //也可以使用匿名内部类来完成，因为这些类都只调用了一次
        new Animal(){
            @Override
            public void shout() {
                System.out.println("猫会喵喵叫...");
            }
        }.shout();
        new Animal(){
            @Override
            public void shout() {
                System.out.println("狗会汪汪叫...");
            }
        }.shout();
    }
}

abstract class Animal{ //定义一个抽象的父类

    public abstract void shout();

}

class Cat extends Animal{

    @Override
    public void shout() {
        System.out.println("猫会喵喵叫...");
    }
}

class Dog extends Animal{

    @Override
    public void shout() {
        System.out.println("狗会汪汪叫...");
    }
}
