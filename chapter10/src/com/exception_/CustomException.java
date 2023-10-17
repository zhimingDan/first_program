package com.exception_;

//自定义异常：
/*要求如下：
要求输入的年龄在18~120之间，否则输出一个异常
 */
public class CustomException {
    public static void main(String[] args) {
        int age = 150;
        if(!(age >= 18 && age <= 120)){ //如果年龄不在这个之间，那么就抛出一个异常
            throw new AgeException("输入的年龄应该在18-120之间"); //相当于创建了一个匿名对象,调用构造器
        }
        System.out.println("年龄为：" + age);
    }
}

class AgeException extends RuntimeException{
    public AgeException(String message) { //这个构造器可以把你输入的话输出到异常中
        super(message);
    }
}


