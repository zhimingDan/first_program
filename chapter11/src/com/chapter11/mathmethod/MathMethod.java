package com.chapter11.mathmethod;

import java.util.Arrays;

public class MathMethod {
    public static void main(String[] args) {
        //利用random获取一个随机整数,这个整数的返回在a,b之间
        //老师的推导思路：
        //  (int)a <=  x <= (int)(a + b - a)
        //去除公共部分(int)a,只要得到后面0 ~ b-a的随机数即可
        //(Math.random()*(b-a+1))得到的就是0 ~ b-a 之间的随机数，然后加上a即可
//        int a = 2;
//        int b = 7;
//        for (int i = 0; i < 5; i++) {
//            System.out.println((int)(Math.random() * (b - a + 1)) + a);
//        }
//
        int[] arr = {2,3,5,6};
        int[] arrNew = Arrays.copyOf(arr,arr.length +1);
        //当拷贝的元素的个数大于原数组的元素的个数，则新数组后面的元素都是该数组类型的默认值
        System.out.println(Arrays.toString(arrNew));
    }
}
