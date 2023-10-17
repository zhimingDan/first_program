package com.chapter08.abstract_;

//抽象类的介绍


public class Abstract01 {
    public static void main(String[] args) {
        AAA aaa = new BBB();
        //父类的引用指向了子类的对象，此时调用方法会有动态绑定机制
        aaa.hi();
    }
}

//定义一个抽象类
abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //思考：这是一个父类的方法，你实现了，但是没有什么意义
    //这也就是父类方法的不确定性，对于不同的子类，父类的方法有着不同的实现(因为父类本身就是一个模板)
    //->考虑将该方法设计为抽象的方法(abstract)
    //->所谓抽象的方法实际上就是没有实现的方法
    //->所谓没有实现的方法，就是没有方法体
    //->一般来说抽象类会被继承，由子类来实现

//    public void eat(){
//        System.out.println("这个动物有吃东西的动作，但是不知道吃什么");
//    }
    //--->方法改为：
    public abstract void eat();  //改为抽象的方法后，此时类也应该改为抽象的类
}

class AAA{
    //父类中私有的方法是不构成重写的,因为父类中的private表示对子类是不见的
//    private void hi(){
//        System.out.println("父类中的hi");
//    }
    void hi(){
        System.out.println("父类中的hi");
    }
}

class BBB extends AAA{
    public void hi(){
        System.out.println("子类中的hi");
    }
}


