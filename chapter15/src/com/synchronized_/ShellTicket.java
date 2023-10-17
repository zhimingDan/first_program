package com.synchronized_;

//使用线程同步来解决售票问题：
//让三个售票口同时售卖100张票
public class ShellTicket {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();


        //以下方法会出现一个问题：就是票已经卖完了，但是还有窗口在进行售卖，导致出现负数的情况
        //使用实现接口的方式也会出现超买

        //对synchronized关键字的理解：
        //1.如果是继承Thread类，那么每创建一个对象，就是一个线程，每个线程在执行synchronized方法的时候
        //  拿到的是各自不同的锁，因此起不到同步的作用
        //2.但是如果是实现了Runnable接口，那么所有的线程都是共用一个对象，因此所有线程也是共用一个锁
        //  此时才能达到同步的目的。但是如果直接在run方法上使用synchronized关键字，会出现都调用同一个方法的情况
//        ticket1.start();
//        ticket2.start();
//        ticket3.start();

        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
    }
}


class Ticket implements Runnable{
    private  int num1 = 100; //因为三个售票口同时售卖，因此创建一个static属性，公用票数
    //可以发现，在run方法上使用synchronized关键字是不能实现线程同步的
    Object object = new Object();

    //对于public synchronized  static void method(){}这样的静态方法，此时的锁不是this，而是当前对象类的类名 Ticket
    public synchronized  static void method(){}

    //public synchronized void run() {}就是一个同步方法，这是锁在this(当前对象)上，因为是实现了Runnable接口，
    //因此各个Thread对象中传入的都是同一个对象，因此this是指向同一个对象
    //实际上也可以使用代码块来实现，但是要保证不同的线程取得的锁对象是同一个对象
    @Override
    public /*synchronized*/ void run() {

        //如果觉得互斥方法执行效率较低，可以尝试使用互斥代码块
        //这里传入的也不一定是this，只要传入的是同一个对象就可以了
        //因为Thread类中传入的三个对象都是同一个对象，因此它们调用的属性也是同一个属性
        synchronized(/*this*/object){
            while(true){
                if(num1 <= 0){
                    System.out.println("票已售完~~");
                    break;
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("接收到一个中断异常");
                }

                System.out.println("窗口 ：" + Thread.currentThread().getName() +
                        " 正在售票，剩余票数为：" + (--num1));
            }
        }
    }
}