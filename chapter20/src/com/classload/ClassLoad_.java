package com.classload;

//类加载中的连接阶段 - 准备
public class ClassLoad_ {

}

class A{
    //在类加载的准备阶段中
    //n1是不会进行初始化的，因为n1是实例变量而不是静态变量，因此在这个阶段不会分配内存空间
    //n2是静态变量，因此会被分配内存，而且默认初始化为0，而不是20
    //n3是static final 类型，是一个常量，因此它和静态变量不同，因为一旦赋值就不会发生改变了，因此会直接赋值30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}
