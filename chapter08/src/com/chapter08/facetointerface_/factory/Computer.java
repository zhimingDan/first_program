package com.chapter08.facetointerface_.factory;

//Computer就相当于使用接口的类

public class Computer {
    private Output out;

    public Computer(Output out) {
        this.out = out;
    }

    //定义一个模拟获得字符串输入的方法
    public void keyIn(String mags){
        out.getData(mags);
    }

    //定义一个模拟打印的方法
    public void print(){
        out.out();
    }
}
