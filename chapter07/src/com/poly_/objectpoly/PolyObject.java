package com.poly_.objectpoly;

public class PolyObject {
    public static void main(String[] args) {
        //体验对象多态的特点

        // 多态的特点就是针对重写：
        // 因为父类的引用虽然是指向子类的对象
        // 但是实际上是指向子类对象在堆内存中的父类的那一块，因此父类引用可以调用所有的父类的方法
        // 并且调用的层级是从父类这个层级开始的，当然也要遵守访问权限的限制，而且不能调用子类中特有的属性和方法

        // 当对父类引用进行向下转型后，这个时候实际上引用是指向子类对象在堆内存中的子类的那一块
        // 因此，此时访问的层级是从子类开始的。
        //此时animal的编译类型是Animal，运行类型是Dog
        Animal animal = new Dog();
        //因为运行时，这时即执行到改行是animal的运行类型是Dog，所以cry就是Dog的cry
        animal.cry();//此时执行的结果是小狗汪汪叫

        animal = new Cat(); //编译类型仍然是Animal，但是运行类型变成了Cat,本质运行的时候，看的是堆内真正的对象
        animal.cry(); //此时执行是小猫喵喵叫
    }
}
