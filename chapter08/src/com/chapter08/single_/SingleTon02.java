package com.chapter08.single_;


//单例模式 ----> 懒汉式
public class SingleTon02 {
    public static void main(String[] args) {
        Cat cat1 = Cat.getInstance();
    }
}

class Cat{
    private String name;
    private static Cat cat; //定义一个对象实例，但是不创建对象，这样就可以达到使用才创建的目的

    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance(){  //只要调用该方法，此时就会创建一个对象，但是可能会有线程安全问题
        if(cat == null){
            cat = new Cat("榴莲");
        }
        return cat;
    }
}
