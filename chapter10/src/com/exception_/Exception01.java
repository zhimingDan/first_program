package com.exception_;

public class Exception01 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;
        //当程序执行到int res = n1 / n2时，此时程序就会出现(抛出)异常，ArithmeticException
        //当抛出异常后，程序就会崩溃，然后退出了
        //这样的处理机制并不好，不应该因为出现了一个不算致命的问题，就导致了整个程序崩溃了
        //此时java设计者提供了一个异常处理机制，来解决一下问题
        //如果程序员认为一段代码可能会出现问题，此时采用try-catch异常处理机制来解决，从而保证代码的健壮性
        //步骤：选中该代码，使用快捷键 ctrl + alt + t，然后选择try-catch

        //int res = n1 / n2;
        //如果进行了异常处理，即使程序出现了异常，也是可以继续执行的

        try {   //如果以下代码有问题
            int res = n1 / n2;
        } catch (Exception e) { //系统就会给你自动捕获，捕获异常的对象
             //e.printStackTrace(); //在这里将捕获信息输出
            //或者采用
            System.out.println(e.getMessage()); //输出异常信息
        }
        System.out.println("程序继续执行");
    }

    //异常处理的方式只有两种：使用try-catch直接处理异常或者使用throws关键字将异常抛给调用异常的方法
}
