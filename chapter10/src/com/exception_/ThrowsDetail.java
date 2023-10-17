package com.exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//抛出异常中的细节
public class ThrowsDetail {

    public static void f1(){
        //这里会报错
        /*
        因为调用的方法是编译异常，f2()中的编译异常抛给了f1(),编译异常是一定要进行处理的，
        因此f1()方法作为调用者，要么直接把异常抛给f1()方法的调用者，让f1()方法的调用者来处理这个异常
        要么使用try-catch-finally直接把f2()包起来，来处理编译时的异常
         */
        //f2();
    }
    public static void f2() throws FileNotFoundException {
        //FileNotFoundException是一个编译异常，因此必须处理
        FileInputStream fis = new FileInputStream("d://aa.test");
    }

    public static void f3(){
        /*
        作为f4()的调用者，对f4()抛出的异常，可以直接进行处理，也可以不处理，因为运行的异常会有一个默认往上抛的
        操作
         */
        f4();
    }
    public static void f4()/*throws ArithmeticException*/{ //这里有个默认抛出异常的动作
        int n1 = 10;
        int n2 = 0;
        int res = n1 / n2;
        //因为是运行时的异常，如果不对异常进行处理，该方法f4()就会默认将异常抛出
    }
}

