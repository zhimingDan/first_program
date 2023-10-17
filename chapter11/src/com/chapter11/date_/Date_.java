package com.chapter11.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Date_{
    public static void main(String[] args) throws ParseException {
        Date date = new Date();//获取当前系统的时间，但是格式默认是国外的格式，因此通常需要进行格式化

        //格式化使用SimpleDateFormat这个类来进行格式化操作

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E"); //E代表当前星期几
        String format = sdf.format(date); //将日期的格式指定按照指定的格式输出
        System.out.println(format);

        //构造器二：通过输入毫秒数来获取时间,其实时间为1970年1月1日开始。
        Date date1 = new Date(12);
        System.out.println("date1的时间= " + date1);

        //可以把一个格式化的String转换成对应的Date
        //用得到的Date进行输出的时候，格式是国外的形式的格式，如果需要指定格式输出，需要进行转换
        //在把String -> Date的时的数据格式，需要和sdf对象的数据格式保持一致，否则就会抛出异常

        String str = "2023年04月21日 03:44:19 星期五";
        date = sdf.parse(str); //可以使用快捷键alt + enter直接将异常抛出
        System.out.println(date);
    }
}
