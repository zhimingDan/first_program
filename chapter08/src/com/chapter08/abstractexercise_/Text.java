package com.chapter08.abstractexercise_;


//将这个和接口进行比较，使用类去继承抽象类，然后利用多态的应用中的多态形参可以达到和接口相同的效果

public class Text {
    public static void main(String[] args) {
        Dog dog = new Dog();
        work(dog);
        Cat cat = new Cat();
        work(cat);
    }

    public static void work(Animal animal){//利用多态应用中的多态参数，不同的对象调用不同的方法
        animal.eat();
        animal.cry();
    }
}

abstract class Animal{ //定义一个抽象类，并且在抽象类中定义抽象方法
    public abstract void eat();
    public abstract void cry();
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("小狗在吃骨头");
    }

    @Override
    public void cry() {
        System.out.println("小狗在哭泣");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("小猫在吃鱼");
    }

    @Override
    public void cry() {
        System.out.println("小猫在哭泣");
    }
}
