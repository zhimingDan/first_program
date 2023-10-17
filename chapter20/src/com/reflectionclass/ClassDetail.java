package com.reflectionclass;

//反射类中需要注意的细节
public class ClassDetail {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class也是类，因此也会继承Object类

        //2.Class类的对象不是new出来的，而是由系统创建的
        //(1) 传统创建对象的方式
        //Cat cat = new Cat();

        //(2) 反射方式创建
        //因为类加载只会加载一次，因此如果上面常见了对象，那么下面用Class类的反射方式就不会再及逆行类加载
        Class cls = Class.forName("com.reflection.Cat");

        //3.对于某个类的Class类对象，内存中只会存在一份，因为类只会加载一次
        Class cls1 = Class.forName("com.reflection.Cat");

        //可以发现，这两个类对象的哈希值相等，说明这两个类对象是同一个对象
        System.out.println(cls.hashCode());
        System.out.println(cls1.hashCode());
    }
}
