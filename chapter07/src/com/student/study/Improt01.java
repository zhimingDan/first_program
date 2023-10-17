//package的作用是用来声明当前类所在的包位置，且声明位置只能在最上面
//小结论：如果类是创建在包中,那么一定需要包位置声明，如果是直接创建在项目下面，那么可以不用使用包声明
package com.student.study;

import java.util.Arrays;

public class Improt01 {
    public static void main(String[] args) {
        //使用系统提供的Arrays类来完成数组排序
        int[] arr = {1,-1,4,6,8};
        //传统方法是自己进行编写代码来实现冒泡排序
        //但是系统提供了相关的类，可以方便完成排序 Arrays
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            }
        }
    }
