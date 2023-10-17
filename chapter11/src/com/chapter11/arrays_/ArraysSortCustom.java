package com.chapter11.arrays_;


//通过自己写冒泡排序，深入理解定制排序以及接口编程的思想

import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr =  {1,-1,3,9,5};
        //bubble(arr);
        //System.out.println("普通冒泡排序后的结果：");
        //System.out.println(Arrays.toString(arr));

        //下面使用定制冒泡排序，理解接口编程的思想：
        bubbleInterface(arr, new Comparator() {//利用了动态绑定机制，这样调用的是匿名内部类中重写的方法
            //然后这里创建一个匿名内部类，并且重写接口Comparator中的compare方法
            @Override
            public int compare(Object o1, Object o2) {
                //使用了向下转型 + 拆箱
                int num1 = (Integer)o1;
                int num2 = (Integer)o2;
                return num1 - num2;
            }
        });
    }

    public static void bubble(int[] arr){
        int temp; //设置一个中间变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j] > arr[j+1]){ //实现从小到大排序
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleInterface(int[] arr, Comparator c){ //传入数组的同时，传入接口
        int temp; //设置一个中间变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(c.compare(arr[j],arr[j + 1]) > 0){ //我这里传入一个接口，然后调用接口的compare方法
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
