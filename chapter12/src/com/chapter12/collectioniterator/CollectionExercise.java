package com.chapter12.collectioniterator;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    创建一个Dog类，里面有属性name,age。放到ArrayList中，赋给ArrayList使用
 */
public class CollectionExercise {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Dog("jack",2));
        col.add(new Dog("tom",3));
        col.add(new Dog("jerry",4));
        Iterator iterator = col.iterator();
        //方式一：使用迭代器来遍历
        while (iterator.hasNext()) {
            Object dog =  iterator.next(); //这个的返回类型是Object，因此只能用Object类型来接收
            System.out.println(dog); //动态绑定机制
        }

        //方法二：使用增强for循环
        System.out.println("================");
        for (Object o : col) {
            System.out.println(o);
        }

    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
