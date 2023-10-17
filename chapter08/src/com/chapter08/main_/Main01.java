package com.chapter08.main_;

public class Main01 {

    //定义一个静态变量
    public static String name = "jack";

    //定义一个非静态变量
    private int num = 1000;

    //定义一个静态方法：
    private static void hi(){
        System.out.println("静态方法中输出hi");
    }

    //定义一个非静态方法

    private void cry(){
        System.out.println("非静态方法输出cry");
    }

    public static void main(String[] args) { //主方法是一个静态的方法
        System.out.println(name); //主方法中可以直接调用静态变量
        //无法在主方法中直接调用非静态变量
        //System.out.println(num);
        //System.out.println(this.num);//静态方法中不能出现this,super等带有对象信息的关键字

        //因此必须创建一个对象，才能调用非静态的变量和方法
        Main01 main01 = new Main01();
        System.out.println("main01.num =" + main01.num);

        hi(); //静态方法可以直接调用
        main01.cry(); //非静态方法只能通过对象来调用

        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }

    }
}
