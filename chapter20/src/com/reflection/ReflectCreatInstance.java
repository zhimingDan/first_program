package com.reflection;

import java.lang.reflect.Constructor;

public class ReflectCreatInstance {
    public static void main(String[] args) throws Exception {
        //1.先获取得到User类的Class对象
        Class<?> aClass = Class.forName("com.reflection.User");
        //2.通过public的无参构造器创建实例
        Object o = aClass.newInstance(); //newInstance只能创建无参构造器
        System.out.println(o);
        //3.通过public的有参构造器创建实例
        //有参构造器不能使用newInstance直接获取，而且形参里面传入的是类型
        System.out.println("============public的带有形参的===============");
        //3.1.先得到对应的构造器
        //3.2.然后在创建实例
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object obj = constructor.newInstance("tom"); //此时传入的才是实参
        System.out.println(obj);
        //4.通过非public的有参构造器创建实例
        //4.1.得到private对象,这里的形参是什么类型就传入什么类型，不能因为是int类型，就传入Integer类型
        Constructor<?> constructor1 = aClass.getDeclaredConstructor(int.class, String.class);
        //4.2.创建实例
        //因为得到的对象是私有的，因此无法直接创建实例,因此下面这个直接创建实例的语句是错误的
        //Object o1 = constructor1.newInstance(1000, "merry");

        //此时需要对private进行暴破[暴力破解]，通过反射可以访问private的构造器/方法/属性，在反射面前都是纸老虎
        constructor1.setAccessible(true); //表示进行暴破
        Object o1 = constructor1.newInstance(1000, "merry");
        System.out.println("==============private的带有形参的===========");
        System.out.println(o1);


    }
}

class User {
    private int age = 10;
    private String name = "jack";

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
