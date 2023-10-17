package com.synchronized_;

/*  编程题：
    1.有两个用户分别同时从同一个账户上面取钱(初始余额为10000)
    2.两个人每次分别去100元，当余额不足的时候，就不能取钱了
    3.要求：不能出现超取的现象
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Account account1 = new Account();
        Thread thread1 = new Thread(account1);
        Thread thread2 = new Thread(account1);
        thread1.setName("用户1");
        thread2.setName("用户2");
        thread1.start();
        thread2.start();
    }
}

class Account implements Runnable {

    private double money = 10000;
    @Override
    public void run() {
            while (true) {
                synchronized (this){
                    if(money <= 100){
                        System.out.println("余额不足！！");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "正在取钱！！" + "\t余额为 -> " + (money -= 1000));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }
}