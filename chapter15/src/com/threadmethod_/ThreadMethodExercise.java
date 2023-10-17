package com.threadmethod_;

/*  要求如下：
    1.主线程每隔1s，输出一个hi,一共输出10次
    2.当输出到第五个hi的时候，启动一个子线程(要求实现Runnable接口)，每隔1s输出一个hello,等该线程输出10个hello后
    该线程退出
    3.主线程继续输出剩下的hi
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        for(int i = 1; i<=10;i++){
            System.out.println("hi " + i);
            Thread.sleep(1000);
            if(i == 5){
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束....");
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { //捕获中断
                //throw new RuntimeException(e);
            }
        }
        System.out.println("子线程退出...");
    }
}
