package com.chapter12.set_.hashset_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*  练习：
    定义一个Employee类，该类包含：private成员属性(name,age)要求：
    1.创建三个Employee对象放到HashSet中
    2.当name 和 age相同的时候，认为是相同的员工，不能添加到HashSet集合中
 */
public class HashSetExercise_ {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add(new Employee("jack",20));
        hashSet.add(new Employee("tom",20));
        hashSet.add(new Employee("jack",20));
        System.out.println(hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //我重写的方法还是有点小问题的！！！
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null)
//            return false;
//        if(this instanceof Employee){ //判断输入的类和本类是不是同一个类型
//            Employee e = (Employee) obj;  //向下转型
//            return this.name == e.name && this.age == e.age;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
