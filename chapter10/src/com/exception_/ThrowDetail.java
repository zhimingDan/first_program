package com.exception_;

//throw关键字的细节：

public class ThrowDetail {
    public static void main(String[] args) {
        try {
            /*
            执行的步骤是：
            1.先执行输出语句：进入方法A，但是下面是一个生成异常，因此会先执行finally中的输出语句
            2.然后生成一个异常，因为try-finally并没有处理异常，因此生成的异常被调用方法者catch所捕获，输出异常的信息
            3.最后进行methodB中执行属性语句：进入了B方法，然后执行finally方法中的输出语句
             */
            ReturnException.methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ReturnException.methodB();
        }
    }
}

class ReturnException{
    public static void methodA(){
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("使用methodA的方法");
        }
    }

    public static void methodB(){
        try {
            System.out.println("进入了B方法");
            return;
        } finally {
            System.out.println("调用了B方法的finally");
        }
    }
}
