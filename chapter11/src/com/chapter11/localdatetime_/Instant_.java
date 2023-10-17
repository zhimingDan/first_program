package com.chapter11.localdatetime_;


import java.util.Date;
import java.time.Instant;

//时间戳 Instant ：完成某个操作的时间的标记
public class Instant_ {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now); //一定要注意，这个时间有时区的，我们在东八区，需要加上8个小时

        //通过Date中的静态方法from可以把Instant转化为Date
        Date date = Date.from(now);
        System.out.println(date);
        //通过Date中的toInstant方法可以把Date转换为Instant对象
        now = date.toInstant();
        System.out.println(now);
    }
}
