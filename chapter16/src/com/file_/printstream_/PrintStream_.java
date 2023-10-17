package com.file_.printstream_;

import java.io.IOException;
import java.io.PrintStream;

//打印流只有输出流
//演示PrintStream -> 字节打印流
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        //常用方式
        //因为System.out的编译类型和运行类型都是PrintStream
        PrintStream out = System.out;
        //PrintStream out = new PrintStream(); //没有默认的构造器
        //在默认的情况下，PrintStream输出的位置是在显示器

        /*
        public void print(String s) {
            if (s == null) {
                s = "null";
            }
            write(s);
        }
         */
        //print方法实际上底层调用的还是write
        out.print("hello,world!! 你好，世界！！");

        //因此上述的print方法也可以写成write的方式,但是因为是字节流的方式，因此传入的必须都是byte类型或者byte[] 数组
        out.write("hello,世界".getBytes());
        out.close();


        /**
         * 通过下面的两个改变打印路径的方法可以看出：
         * 1.
         * 实际上System.out的类型就是PrintStream,因此 System.out == PrintStream 两者是可以画上等号的
         * 所以两者都有print() 方法以及 write()方法
         * 只不过因为PrintStream是字节流，因此write()方法只能写入byte，而print因为重载，可以写入任意基本类型
         *
         * 2.
         * 且两者都可以改变打印的位置，而且方法大体相同
         * System时调用方法setOut，然后传入PrintStream，而PrintStream类型可以指定写入的位置(文件)，因此相当于
         * 改变了System的打印的位置
         *
         * 而PrintStream是个字节流，可以直接通过构造器改变，但是如果是标准输出的话，那么就需要使用System.out来
         * 进行赋值，使得PrintStream可以标准输出
         */

        //也可以用PrintStream修改System.out的打印的位置
        String filePath = "e:\\f3.txt";
        System.setOut(new PrintStream(filePath));
        //此时会创建一个文件，并且改变打印路径，把要打印的内容打印到指定的文件中
        System.out.print("hello,你创建了一个新的文件");
        //System.out.write("hello,你创建了一个新的文件".getBytes());

        PrintStream printStream = new PrintStream("e:\\f2.txt");
        printStream.print("你好，你用PrintStream创建了一个新的文件");
        printStream.close();


    }
}
