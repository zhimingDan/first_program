package com.customgeneric_;

import java.util.ArrayList;
import java.util.List;

public class CustomGenericDetail_ {
    public static void main(String[] args) {
        List<Object> objects1 = new ArrayList<>();
        List<String> objects2 = new ArrayList<>();
        List<AA> objects3 = new ArrayList<>();
        List<BB> objects4 = new ArrayList<>();
        List<CC> objects5 = new ArrayList<>();

        //如果是List<?> list ，则表示可以接收任意的泛型类型
        printCollection1(objects1);
        printCollection1(objects2);
        printCollection1(objects3);
        printCollection1(objects4);
        printCollection1(objects5);

        //如果是List<? extends AA> list ，则表示支持AA类以及AA类的子类，规定了泛型的上限
        //printCollection2(objects1);  这两个类型不是AA的子类，因此无法正确接收
        //printCollection2(objects2);
        printCollection2(objects3);
        printCollection2(objects4);
        printCollection2(objects5);

        //如果是List<? super AA> list ，则表示支持AA类以及AA类的父类，规定了泛型的下限
        printCollection3(objects1);  //这两个类型不是AA的子类，因此无法正确接收
        //printCollection3(objects2);
        printCollection3(objects3);
        //printCollection3(objects4);
        //printCollection3(objects5);
    }

    //可以传入所有的泛型
    public static void printCollection1(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //支持AA类以及AA类的子类，规定了泛型的上限
    public static void printCollection2(List<? extends AA> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //支持AA类以及AA类的父类，规定了泛型的下限
    public static void printCollection3(List<? super AA> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

}

class AA{}

class BB extends AA{}

class CC extends BB{}
