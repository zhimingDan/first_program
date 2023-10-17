package com.chapter08.facetointerface_.factory;

public interface Output {//定义一个接口
    //接口中的成员变量只能是静态常量
    public static final int MAX = 50;

    public void out();  //接口中的输出函数
    public void getData(String mags);//接口中得到数据的函数




    default void print(String...mags){
        for(String mag : mags){ //使用增强for循环
            System.out.println(mag);
        }
    }

    default void test(){
        System.out.println("默认的test方法");
    }

}
