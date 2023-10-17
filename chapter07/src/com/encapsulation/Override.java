package com.encapsulation;

//练习：1.编写一个Person类，包括属性/private(name,age),构造器、方法say(返回自我介绍的字符串)
//2.编写一个Student类，继承Person类，增加id ,score属性/private,以及构造器，定义say方法(返回自我介绍信息)
//3.在main中，分别创建Person和Student对象，调用say方法输出自我介绍
public class Override {
    public static void main(String[] args) {
        Person1 person = new Person1("jack",30);  //创建一个对象
        System.out.println(person.say());
        Student student = new Student("tom","19040303",19,90.5);
        System.out.println(student.say());
    }
}

class Person1{
    private String name;
    private int age;
    public Person1(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String say(){
        return "名字:" + name + " 年龄:" + age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}

class Student extends Person1{  //继承父类Person
    public String id;
    private double score;
    public Student(String name , String id, int age,double score){
        super(name,age);//对父类的变量进行初始化
        this.id = id;
        this.score = score;
    }
    public String say(){
        //return "名字:" + getName() + " id:" + id +" 年龄:" + getAge() + " 得分：" + score;
        //代码优化：直接调用父类的say方法，但是必须要用super.say()来表示是父类的方法
        return super.say() + " id " + id + " score" + score;
    }
}
