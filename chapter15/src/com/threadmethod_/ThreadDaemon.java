package com.threadmethod_;

//线程常用方法三：用户线程和守护线程
//如果一个线程没有设置，则默认是用户线程
//守护线程的特点是：当其他所有的线程都结束的时候，这个线程也跟着结束

public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        DaemonDetail daemonDetail = new DaemonDetail();
        //一定要注意：设置守护线程一定在开始线程之前，不然就会抛出一个异常
        daemonDetail.setDaemon(true); //设置线程为守护线程


        daemonDetail.start(); //如果没有设置子线程为守护线程，那么主线程结束的时候，子线程依然在工作
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程正在工作~~" + i);
            Thread.sleep(500);
        }
    }
}

class DaemonDetail extends Thread{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("子线程正在工作~~~  " + (++count));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}