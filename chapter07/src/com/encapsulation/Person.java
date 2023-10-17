package com.encapsulation;

public class Person {
    public static void main(String[] args) {
        Encapsulation01 encapsulation01 = new Encapsulation01();
        //设置对象的名字：
        encapsulation01.setName("学习");
        encapsulation01.setAge(23);
        encapsulation01.setSalary(10000);
        System.out.println(encapsulation01.info());
        //如果直接使用构造器指定属性
        Encapsulation01 jack = new Encapsulation01(20, 10000,"jack");
        System.out.println("=====输出jack的信息=======");
        System.out.println(jack.info());//此时可以发现自己写的set方法被别人使用构造器绕过去了
        //解决方案是：将set方法写在构造器中，这样仍然可以验证数据

    }
}
