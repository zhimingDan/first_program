package com.generic_;

import java.util.ArrayList;
import java.util.Comparator;

/*  课堂练习：
    定义一个Employee类
    1.该类中包含private成员变量name,sal,birthday,其中birthday为MyDate类的对象
    2.为每个属性定义一个getter,setter方法
    3.重写toString 方法，输出name ,sal,birthday;
    4.MyDate类中包含：private成员变量month,day,year;并为每一个属性提供getter 和 setter方法
    5.创建该类的3个对象，并把这些对象放入到ArrayList集合中，ArrayList集合需使用泛型来定义。
      对集合中的元素进行排序，并遍历输出。
    6.排序方式：调用ArrayList中的sort方法，传入Comparator对象[使用泛型]，先按照name排序
      如果name相同，则按照生日的先后进行排序
 */
public class Generic03 {
    public static void main(String[] args) {
        //使用泛型传入三个对象
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack",10000,
                new MyDate(2001,5,22)));
        employees.add(new Employee("tom",12000,
                new MyDate(2003,8,23)));
        employees.add(new Employee("rose",15500,
                new MyDate(1999,4,10)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //为什么这里可以直接使用 == 而不是equals()方法来判断？
                //因为这里的String都是采用的方式一创建的，因此都是指向常量池，如果字符串相同，那么就是指向同一个对象，
                // 但是如果不同，则肯定指向的不是同一个对象
                if(o1.getName() != o2.getName()){ //如果两者的名字不相等，那么就进行字符串的比较
                    return o1.getName().compareTo(o2.getName());
                }

                if(o1.getBirthday().getYear() != o2.getBirthday().getYear()){//如果两者的年份不相等，那么就按照年份排序
                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                }else if(o1.getBirthday().getMonth() != o2.getBirthday().getMonth()){  //如果两者的年份不同，则直接按照年份就可以比较出大小
                    return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                }else{
                    return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                }
            }
        });

        //采用增强for进行遍历
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\t薪水" + sal +birthday;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "年" + year +" 月" + month + " 日" + day;
    }
}
