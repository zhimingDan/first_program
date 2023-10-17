package com.customgeneric_;

//自定义泛型类的细节说明
public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}

class Tiger<T,R,M>{
    String name;
    T t;
    R r;
    M m;
}

//1.普通的成员也可以只用泛型，但是静态的成员不能使用泛型
//2.使用泛型的数组可以定义，但是不能进行初始化操作(因为类型不确定，系统无法确定开辟的空间的大小)
//3.泛型的类型是在创建对象的时候确定的
//4.如果创建对象的时候，没有指定泛型的类型，那么会自动默认为Object类型
