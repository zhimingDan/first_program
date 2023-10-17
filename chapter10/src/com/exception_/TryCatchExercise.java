package com.exception_;

import java.util.Scanner;

//如果用户输入的不是一个整数，就一直提醒他输入一个整数，直到输入整数为止
public class TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            try {
                System.out.println("请输入一个整数");
                //int res = scanner.nextInt(); //这个方法不行，正确的步骤是接收一个字符串，然后将字符串解析为int类型
                //使用上面这个代码的时候，该内存中的数据并没有被取出来，因为系统以为内存中的数据是人为输入的
                //就会一直读取内存中的数据，因此这里会无限报异常
                int res = Integer.parseInt(scanner.next());
                loop = false;
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }

//        while(true){
//            System.out.println("请输入一个整数: ");
//            int res = scanner.nextInt();
//            System.out.println("你输入的值为：" + res);
//        }
        //System.out.println("程序退出成功");
    }
}

