package com.threaduse_;

//让三个售票口同时售卖100张票
public class ShellTicket {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();

        //以下方法会出现一个问题：就是票已经卖完了，但是还有窗口在进行售卖，导致出现负数的情况
        //使用实现接口的方式也会出现超买
        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}


class Ticket extends Thread{
    private static int num = 100; //因为三个售票口同时售卖，因此创建一个static属性，公用票数
    @Override
    public void run() {
        while(true){
            if(num <= 0){
                System.out.println("票已售完");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 ：" + Thread.currentThread().getName() +
                    " 正在售票，剩余票数为：" + (--num));
        }
    }
}