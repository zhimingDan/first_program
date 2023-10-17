package com.exercise;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
    1.利用Class类的forName方法得到File类的class对象
    2.在控制台打印File类的所有构造器
    3.通过newInstance的方法创建一个File对象，并且创建E:\myNew.txt文件
 */
public class HomeWork02 {
    public static void main(String[] args) throws Exception{
        Class<?> file = Class.forName("java.io.File");
        Constructor<?>[] constructors = file.getDeclaredConstructors();
        for (Object o : constructors) {
            System.out.println(o);
        }
        //首先得到构造器
        Constructor<?> constructor = file.getConstructor(String.class);
        Object o = constructor.newInstance("e:\\myNew.txt");

        //创建一个方法
        Method createNewFile = file.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
