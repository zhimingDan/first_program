package com.encapsulation;
/*
  练习：实现一个小程序，不能顺便查看一个人的年龄，工资等隐私，并对设置的年龄进行合理验证，年龄合理就设置
  年龄不合理就给默认，年龄必须在1-120之间，工资不能直接查看，名字的长度在2-6个字符之间
 */
public class Encapsulation01 {
    private int age;
    private double salary;
    public String name; //名字公开

    //将构造器与setXxx相结合


    public Encapsulation01() {
    }
    //有三个属性的构造器
    public Encapsulation01(int age, double salary, String name) {
//        this.age = age;
//        this.salary = salary;
//        this.name = name;
          setName(name);
          setSalary(salary);
          setAge(age);
    }

    public void setAge(int age){
        if(age >= 1 && age <=120){ //判断年龄是否在1-120岁之间
            this.age = age;
        }else{
            System.out.println("你输入的年龄有误！,将给你设置默认年龄0岁");
            this.age = 0;
        }
    }
    public int getAge(){//返回对象的年龄
        return this.age;
    }

    public void setSalary(double salary){ //设置对象的薪水
        this.salary = salary;
    }
    private double getSalary(){ //返回对象的薪水
        //可以增加对当前对象的权限判断
        return this.salary;
    }

    public void setName(String name){ //设置对象的名字
        if(name.length() >= 2 && name.length()<=6){ //判断名字的长度是否符合要求
            this.name = name;
        }else{
            System.out.println("您输入的名字长度有误");
            this.name = "无名氏";
        }
    }
    public String getName(){
        return this.name;
    }
    public String info(){
        return "name " + this.name + " age " + this.age + " salary " + this.salary;
    }
}
