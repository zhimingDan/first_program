package com.file_.standard_;

//标准输入和标准输出
public class InputAndOutput {
    public static void main(String[] args) {

        //System类的public final static InputStream in = null;
        //System.in的编译类型是 InputStream
        //System.in的运行类型是 BufferedInputStream
        //表示标准输入 -> 键盘
        System.out.println(System.in.getClass());

        //System类的public final static PrintStream out = null;
        //System.out的编译类型是 PrintStream
        //System.out的运行类型是 PrintStream
        //表示标准输出 -> 显示器
        System.out.println(System.out.getClass());

    }
}
