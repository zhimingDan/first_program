package com.chapter12.set_.hashset_;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    public static void main(String[] args) {
        Set hashSet = new HashSet();

        //每次添加一个值会有一个boolean类型的返回值，如果添加成功则返回true，否则返回false
        System.out.println(hashSet.add("jack"));
        System.out.println(hashSet.add("tom"));
        System.out.println(hashSet.add("jack"));
        System.out.println(hashSet.add("john"));
        System.out.println(hashSet.add("rose"));

        hashSet.remove("jack"); //指定删除某个元素

        //进阶：

        hashSet = new HashSet(); //重置hashSet对象

        hashSet.add("luck");
        hashSet.add("luck");  //加入失败
        hashSet.add(new Dog("tom"));
        hashSet.add(new Dog("tom")); //加入成功
        System.out.println(hashSet);

        //非常经典的面试题：
        hashSet.add(new String("jack"));
        hashSet.add(new String("jack")); //这里加入不进去
    }
}

class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
