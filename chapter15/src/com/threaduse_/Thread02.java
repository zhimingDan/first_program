package com.threaduse_;

//使用Runnable实现多线程

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        //dog.start(); //这里不能直接调用start()方法，因为Runnable接口中压根就没有这个方法

        //这里使用的是代理模式
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable{

    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("hi" + (++count) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count == 10){
                break;
            }
        }
    }
}
