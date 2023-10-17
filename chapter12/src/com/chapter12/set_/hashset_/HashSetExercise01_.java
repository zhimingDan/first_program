package com.chapter12.set_.hashset_;

import java.util.HashSet;
import java.util.Objects;

/*  练习：
    定义一个Employee01类，该类包含：private成员属性(name,age,birthday(MyDate类型)),其中MyDate类型中有year,month,day属性
    要求：
    1.创建三个Employee对象放到HashSet中
    2.当name 和 birthday相同的时候，认为是相同的员工，不能添加到HashSet集合中
*/
public class HashSetExercise01_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee01("jack",20,new MyDate(2001,12,23)));
        hashSet.add(new Employee01("tom",20,new MyDate(2001,12,23)));
        hashSet.add(new Employee01("jack",20,new MyDate(2001,12,23)));
        System.out.println(hashSet);
    }
}

class Employee01{
    private String name;
    private double age;
    private MyDate birthday;

    public Employee01(String name, double age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    //重写生成hashCode以及equals方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return name.equals(that.name) && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,birthday.hashCode());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age;
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean equals(Object obj){
        if(this == obj) //如果输入的是同一个对象，那么就直接返回true
            return true;
        if(obj == null || !(obj instanceof MyDate)) //写源码的时候一定要注意这个地方，一定要改成！
            return false;
        MyDate myDate = (MyDate) obj;
        return this.year == myDate.year && this.month == myDate.month && this.day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
