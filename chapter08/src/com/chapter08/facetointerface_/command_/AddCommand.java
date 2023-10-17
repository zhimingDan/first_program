package com.chapter08.facetointerface_.command_;

public class AddCommand implements Command{
    //实现接口中的抽象方法
    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            sum += i;
        }
        System.out.println("数组中的元素之和为: " + sum);
    }
}
