package com.threaduse_;

//实现多个子线程
public class ThreadExercise {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable{

    int count = 0 ;
    @Override
    public void run() {
        while(true){
            System.out.println("T1 -- > hello" + (++count));
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

class T2 implements Runnable{
    int count = 0 ;
    @Override
    public void run() {
        while(true){
            System.out.println("T2 -- > hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(count == 5){
                break;
            }
        }
    }
}
