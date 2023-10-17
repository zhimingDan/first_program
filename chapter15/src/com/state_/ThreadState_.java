package com.state_;

//演示多线程中的状态：
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " -> " + t.getState()); //输出子线程的名字以及子线程所处的状态

        t.start();

        //如果子线程t不处于超时等待的状态，那么就运行主线程中的以下代码
        while(Thread.State.TIMED_WAITING != t.getState()){
            System.out.println(t.getName() + " -> " + t.getState());
            Thread.sleep(350);
        }

        System.out.println(t.getName() + " -> " + t.getState());
    }
}

class T extends Thread{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("子线程正在运行~~~" + (++count));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("子线程已被中断");
            }
        }
    }
}
