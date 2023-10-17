package com.chapter08.facetointerface_.command_;

public class PrintCommand implements Command{
    //重写接口中的实现方法
    @Override
    public void process(int[] target) {
        System.out.println("数组的元素如下");
        for(int i : target){
            System.out.print(i + " ");
        }
    }
}
