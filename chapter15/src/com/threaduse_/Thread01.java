package com.threaduse_;
//多线程的案例演示：
//当一个类继承了Thread类或者实现了Runnable接口，都可以把这个类视为一个线程类
//但是线程的执行入口是在run()方法中执行的，就好像主线程的执行入口是main方法一样

public class Thread01 {
    public static void main(String[] args) {
        //创建一个对象，实际上就是创建了一个进程
        Cat cat = new Cat();
        //调用start方法实际上就是运行Cat类中的run方法

        /*
        1.实际上底层调用的是start0()方法
        2.start0()方法是本地方法，是由JVM机调用，底层由C/C++实现
        3.真正实现多线程的效果是：start0(),而不是run()。是由start0()来调用run
         */
        cat.start(); //相当于启动线程 -----> 最终会跑去执行Cat的run方法

        //为什么不直接调用Cat类中的run方法呢？
        //因为如果是下面这种方式直接调用的话，实际上主线程中并没有单开一个子线程
        //这其实还是主线程在执行cat中的run方法，也可以看到run方法中的输出当前线程名为：main

        //cat.run();

        //当main线程启动一个子线程的时候，主线程不会发生阻塞，会继续执行
        //这时，主线程和子线程会交替执行

        //打印当前线程的名字：Thread.currentThread().getName();
        System.out.println("主线程正在执行"+Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i =" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//1.当一个类继承了Thread类，该类就可以当作线程使用,线程是在run()方法中运行的
//2.当我们重写了run方法的时候，写上自己的逻辑代码
//3.实际上底层中Thread是实现了Runnable接口。
class Cat extends Thread{
    int count = 0;
    @Override
    public void run() { //重写父类中的run方法，实现自己的逻辑
        while(true){
            System.out.println("jack" + (++count));
            //隔1s休息一次，但是会抛出一个异常
            //这里必须使用try - catch是保证线程在sleep是还能感知异常，能够响应中断，不会睡死
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
