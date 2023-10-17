package com.file_.bufferedreader_;

import java.io.BufferedReader;
import java.io.FileReader;

//使用处理流来进行读取文件的操作
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        String fileName = "E:\\IDEA项目\\first_program\\chapter16\\src\\com\\file_\\createfile_\\CreatFile.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); //这里为了简介，直接将异常抛出

        String line;

        //readLine()方法每次返回一个String，如果读取到文件末尾，就返回一个null，且没有自带换行符
        while ((line = bufferedReader.readLine()) != null) { //每次读取一行
            System.out.println(line);
        }

        //一定要记得关闭对文件的操作
        //虽然这里关闭的是处理流，但是底层关闭的实际上是节点流

        //底层执行的代码是 in.close()，因为动态绑定机制的原因，因此最后关闭的是节点流
        bufferedReader.close();
    }
}
