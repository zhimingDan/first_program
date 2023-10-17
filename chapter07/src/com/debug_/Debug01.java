package com.debug_;
//用Debug来进行循环语句的测试
//时刻注意Debug的快捷键--> F7(进入方法内) F8(逐行执行代码) F9(执行下一个断点)
//shift + F8 (跳出方法体)
public class Debug01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i =" + i);
            System.out.println("sum =" + sum);
        }
        System.out.println("代码执行结束");
    }
}
