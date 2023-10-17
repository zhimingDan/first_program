package com.chapter08.facetointerface_.command_;

public interface Command {

    public void process(int[] target);  //对输入的数组进行处理，但是具体的处理方法还没确定

}
