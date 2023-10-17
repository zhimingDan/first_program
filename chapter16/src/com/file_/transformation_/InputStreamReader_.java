package com.file_.transformation_;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//使用转换流来输出
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String fileName = "e:\\a.txt";

        //解读：
        //1.把FileInputStream转成InputStreamReader
        //2.指定读取文件编码的格式gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "gbk");

        //上面只是一个转换流，读取文件应该用字符流读取
        //3.将InputStreamReader传入到BufferedReader
        //这就相当于两层包装，先把字节流包装成转换流，然后将转换流包装成字符流
        //BufferedReader br = new BufferedReader(isr);


        //一般在开发中，程序员都会将上面两句话合并到一起来写
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "gbk"));



        System.out.println(br.readLine());

        //只要关闭最外层的流即可
        br.close();

    }
}
