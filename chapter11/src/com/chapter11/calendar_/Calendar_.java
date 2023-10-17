package com.chapter11.calendar_;


import java.util.Calendar;

//第二代日期类：Calendar
public class Calendar_ {
    public static void main(String[] args) {
        //Calendar类是一个抽象类，因此不能直接进行实例化，需要调用getInstance方法来创建对象
        Calendar c = Calendar.getInstance();

        System.out.println(c); //这样实际上相当于调用了toString方法，输出了所有的字段(属性)信息

        //获取日历对象的某个字段：
        System.out.println("年：" + c.get(Calendar.YEAR));

        //这里的月份必须进行+1操作，因为在程序中月份是从0开始进行编号的
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));

        //如果想用24小时制，这个时候只要把 Calendar.HOUR ----->  Calendar.HOUR_OF_DAY即可
        System.out.println("时：" + c.get(Calendar.HOUR));
        System.out.println("分：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calendar方法中没有专门的格式化方法，你想要什么样的形式需要自己去组合
    }
}
