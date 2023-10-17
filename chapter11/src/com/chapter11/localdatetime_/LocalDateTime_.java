package com.chapter11.localdatetime_;


//第三代日期类：

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime_ {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now(); //得到当前的日期以及时间
        //LocalDate now = LocalDate.now();  //只得到当前的日期
        //LocalTime now = LocalTime.now();  //只得到当前的时间
        System.out.println(ldt);

        System.out.println("年：" + ldt.getYear());
        System.out.println("月：" + ldt.getMonth());//这个是得到英文形式的月
        System.out.println("月：" + ldt.getMonthValue()); //得到数字形式的月
        System.out.println("日：" + ldt.getDayOfMonth());
        System.out.println("时：" + ldt.getHour());
        System.out.println("分：" + ldt.getMinute());
        System.out.println("秒：" + ldt.getSecond());


        //第三代日期类格式化输出的方法：格式化日期类为(DateTimeFormatter)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日  HH:mm:ss");
        String format = dtf.format(ldt);
        System.out.println("格式化后的日期为：" + format);


        LocalDateTime localDateTime = ldt.plusDays(1200); //输出1200天后的日期
        System.out.println("1200天后的日期是：" + dtf.format(localDateTime));

        LocalDateTime localDateTime1 = ldt.minusMinutes(12345); //输出12345分钟前的日期
        System.out.println("12345分钟前的日期是：" + dtf.format(localDateTime1));
    }
}
