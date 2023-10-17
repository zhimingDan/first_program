package com.exercise_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//输出转换流
public class OutputStreamWrite_ {
    public static void main(String[] args) throws IOException {

        String fileName = "e:\\b.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName), "gbk");

        //此时可以直接用osw进行写入，也可以用处理流，将osw转换为处理流来进行输出
        osw.write("hello,world~~杰克");
        osw.close();
        System.out.println("文件创建完毕");
    }
}
