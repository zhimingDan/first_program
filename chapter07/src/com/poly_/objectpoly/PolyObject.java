package com.poly_.objectpoly;

public class PolyObject {
    public static void main(String[] args) {
        //体验对象多态的特点

        //此时animal的编译类型是Animal，运行类型是Dog
        Animal animal = new Dog();
        //因为运行时，这时即执行到改行是animal的运行类型是Dog，所以cry就是Dog的cry
        animal.cry();//此时执行的结果是小狗汪汪叫

        animal = new Cat(); //编译类型仍然是Animal，但是运行类型变成了Cat,本质运行的时候，看的是堆内真正的对象
        animal.cry(); //此时执行是小猫喵喵叫
    }
}
