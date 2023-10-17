package com.file_.objectoutputstream_;

import java.io.Serializable;

//最好是保证该对象是公开的，或者序列化和反序列化的地方访问到的对象全类型(包名+类名)是同一个
public class Dog implements Serializable {//如果Dog类没有实现Serializable接口的话，那么就无法进行序列化
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
