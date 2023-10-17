package com.chapter11.string_;

import java.util.Scanner;

/*  编程题：
    输入用户的用户名，密码，邮箱。如果信息录入正确，则提示注册成功，否则生成异常对象，要求如下：
    1.用户名的长度为2,3,4
    2.密码的长度为6，要求全部都是数字
    3.邮箱中包含@和.并且要求@在.的前面

 */
public class StringExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名(长度为2 ~ 4)：");
        try {
            String name = scanner.next();
            if(!(name.length() == 2 || name.length() == 3 || name.length() == 4)){
                throw new LongException("您输入的用户名的长度有误");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("请输入您的密码：");
        try {
            String keyWord = scanner.next();
            if(!(keyWord.length() == 6)){
                throw new LongException("密码长度有误，必须为6位");
            }
            Integer integer = Integer.parseInt(keyWord); //如果有不含数字个符号，则会抛出一个类型转换异常

            //或者使用Character类中的isDigit来判断是否有数字
        } catch (LongException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("请输入您的邮箱：");
        try {
            String mailBox = scanner.next();
            if(mailBox.indexOf("@") == -1 || mailBox.indexOf(".") == -1 || mailBox.indexOf("@") > mailBox.indexOf(".")){
                throw new Exception("邮箱格式异常");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

}

class LongException extends RuntimeException{
    public LongException(String message){
        super(message);
    }
}

