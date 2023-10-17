package com.file_.transformation_;

import java.io.BufferedReader;
import java.io.FileReader;

//首先来看看一个案例：
public class CodeQuestion {
    public static void main(String[] args) throws Exception{
        //当文件的格式是utf-8的时候，此时用字符流是可以顺利的读取文件的内容的
        //如果将文件的格式变成ANSI(国标码，不同的国家不同，中国是gbk),此时读取文件会出现乱码现象

        //由此引出：字符流读取文件的方式是按照utf-8的形式读取的，但是如果遇到文件的格式不是utf-8的时候
        //应该怎么办呢？
        // 因为字节流是一个字节一个字节的读取的，因此此时可以规定字节流读取文件的方式，然后将字节流包装成(转换成)字符流即可

        String fileName = "e:\\a.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));//用字符流来读取一个文件

        System.out.println(bufferedReader.readLine());

        //使用完流后一定要及时关闭流
        bufferedReader.close();
    }
}
