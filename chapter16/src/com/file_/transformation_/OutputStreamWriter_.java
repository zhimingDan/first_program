package com.file_.transformation_;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//使用指定的方式，写入文件
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\b.txt";
        String charSet = "gbk";

        //下面写入的方式会直接在指定路径中创建一个指定的文件，不用自己专门去创建文件，且写入的格式和指定的格式相同
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);

        //用字符流来进行写入
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("hello,world~ 你好，世界");
        bw.close(); // 关闭文件
        System.out.println("按照" + charSet + "格式创建成功");
    }
}
