package com.synchronized_;

import java.util.Scanner;

//编程题：
//1.在main方法中启动两个线程
//2.第一个线程循环随机打印1-100内的整数，直到第二个线程接收到从键盘读取了Q命令
public class HomeWork01 {
    public static void main(String[] args) {
        new Print().start();
        new Read().start();
    }

}

class Print extends Thread {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (Read.ch == 'Q') {
                break;
            }
            System.out.print((int) (Math.random() * 100 + 1) + "\t");
            count++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count % 5 == 0){
                System.out.println();
            }
        }
    }
}

class Read extends Thread{

    public static char ch = ' ';

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ch = scanner.next().charAt(0);
    }
}
