package com.exercise_;

import java.io.Serializable;

//定义一个类来进行序列化
public class Tiger_ implements Serializable {
    private int age;
    private String name;

    public Tiger_(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tiger_{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
