package com.exception_;

import java.util.Scanner;

//编写应用程序，接收命令行的两个参数，计算两个数据相除。
//两个数据相除要求使用方法cal(int n1 , int n2)
//对数据格式不正确，缺少命令行参数，除0进行异常处理
public class EcmDef{
    public static void method(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("请输入第一个数据");
                int num1 = Integer.parseInt(scanner.next());  //把输入的数据解析为int类型
                System.out.println("请输入第二个数据");
                int num2 = Integer.parseInt(scanner.next());  //把输入的数据解析为int类型
                cal(num1,num2);
                break;
            } catch (Exception e) {
                System.out.println("异常信息为：" + e.getMessage());
            }
        }
    }

    public static void cal(int num1, int num2){
        System.out.println("两式相除的结果为：" + num1 / num2);
    }

    public static void main(String[] args) {
        method();
    }
}


class HomeWork{ //使用命令行来进行接收
    public static void main(String[] args) { //命令行就是指args这个数组
        try {
            if(!(args.length == 2)){ //如果数组的长度不正确的话，就报出一个异常,这里体现了一个正难则反的思想
                throw new ArrayIndexOutOfBoundsException("输入的数据个数不正确");
                //throw是自己手动创建一个异常，如果不满足某种条件
                //程序员可以自己自定义一个异常
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println("两式相除的结果为：" + cal(num1,num2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("数据的格式错误");
        }catch(ArithmeticException e){
            System.out.println("算数格式异常");
        }
    }

    public static double cal(int num1,int num2){
        return num1 / num2;
    }
}