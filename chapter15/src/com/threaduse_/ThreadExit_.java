package com.threaduse_;

//线程终止：在主线程中来终止子线程
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        Exit_ exit1 = new Exit_();
        exit1.start(); //这样子程序会一直执行下去

        Thread.sleep(10000);
        exit1.setLoop(false); //达到控制子线程退出的目的
    }
}

class Exit_ extends Thread{
    int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            System.out.println("hi" + (++count) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
