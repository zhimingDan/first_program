package com.debug_;

//Debug创建对象的过程，加深对对象的创建的理解
public class DebugExercise01 {
    public static void main(String[] args) {
        Person person = new Person("jack", 20, "程序员");
        System.out.println(person); //输出Person类中的toString方法
    }
}

class Person{
    private String name;
    private int age;
    private String work;

    public Person(String name, int age, String work) {
        this.name = name;
        this.age = age;
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                '}';
    }
}
