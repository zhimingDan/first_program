package com.debug_;

//用Debug来测试数组下标异常时候的情况
public class DebugArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for (int i = 0; i <= arr.length; i++) {  //当这里小于等于的时候，下标就会产生越界的情况
            System.out.print(arr[i] + " ");
        }
    }
}
