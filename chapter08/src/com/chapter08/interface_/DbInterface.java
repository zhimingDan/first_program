package com.chapter08.interface_;

public interface DbInterface { //创建一个接口

    //在接口中定义两个抽象方法
     void connect();

     void close();

     static void print() {
        System.out.println("可以有默认的方法");
    }
}
