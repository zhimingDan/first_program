package com.chapter11.string_;

//关于String类的细节介绍：
//String对象的创建方式有两种
//1. String s = "hsp";  //指向常量池中的地址
//2. String s1 = new String("hsp"); //利用构造器来创建
//一定要注意实参与形参的传值是不一样的，对于基本数据类型是只拷贝，对于引用数据类型是地址拷贝
//两者创建的方式是不同的

public class StingDetail01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        //因为用方式一创建一个String类型的对象，它的创建方式是在方法区的常量池中查找是否有"abc",
        //如果有，就直接返回常量池中的地址，反之，则会在常量池中创建一个"hsp"后，再返回地址
        //因此本题中 a 和 b的地址是一样的，所以输出为true
        System.out.println(a == b);// T

        //因为String类中重写了父类Object的equals()方法,因此这里是比较内容是否相等，所以输出为true;
        System.out.println(a.equals(b));

        System.out.println("======================================");
        String str1 = "hsp";
        String str2 = new String("hsp");

        //intern()方法实际上是返回该字符串在常量池中的内存！！！
        //str2 = str2.intern();
        System.out.println(str1 == str2.intern());//T
        System.out.println(str2 == str2.intern());//F

        System.out.println("========================================");
        Person person = new Person();
        person.name = "jack";
        Person person1 = new Person();
        person1.name = "jack";

        System.out.println(person.name.equals(person1.name)); //T
        //因为equals()方法的两边都是String类型，而String类型是重写了父类的方法，因此比较的是值相等
        System.out.println(person.name == person1.name);//T
        //这也是为什么使用 == 能判断二者是否相等的原因了
        System.out.println(person.name == "jack");//T
        //因为"jack"是常量池中的内容，因此比较的也是常量池中的地址
    }
}

class Person {
    public String name;
}
