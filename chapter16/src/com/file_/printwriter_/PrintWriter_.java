package com.file_.printwriter_;


import java.io.IOException;
import java.io.PrintWriter;

//演示PrintStream -> 字节打印流
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //如果想要PrintWriter是标准输出的话，不能和PrintStream一样直接赋值，而是用构造器来实现

        //PrintWriter printWriter = new PrintWriter(System.out); //此时表示标准输出

        //它的构造函数中，可以直接写入文件的地址，也可以写入一个Writer抽象类的子类，从而变成处理流
        PrintWriter printWriter = new PrintWriter("e:\\f5.txt");
        printWriter.println("hello,tom");

        //注意：一定要关闭流的操作才能将文件正确的写入，否则，是不会保存的
        printWriter.close();
    }
}
