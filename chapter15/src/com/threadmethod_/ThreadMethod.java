package com.threadmethod_;

//多线程中的常用方法第二组： yield 和 join 的演示
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程正在吃包子  " + i);
            Thread.sleep(1000);
            if(i == 4){
                //t1.join(); //如果主线程到4的时候，让子线程先执行，执行完后，主线程再执行
                Thread.yield(); //主线程礼让其他的子线程先执行
            }
        }
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程正在吃包子  " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { //捕获发生的中断异常
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程的包子全部吃完了！！！");
    }
}