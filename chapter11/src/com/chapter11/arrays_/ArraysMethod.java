package com.chapter11.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod {
    public static void main(String[] args) {
        //演示sort关键字来实现数组的排序
        Integer[] integers = {1,-1,3,9,5};

        //可以自己直接使用冒泡排序，也可以使用Arrays提供的排序方法sort()
        //因为数组是引用类型，所以数组通过sort排序后会直接影响到实参！！！(因此后面不用去接收排序后的结果)
        //sort是构成重载的，可以使用默认排序。也可以通过传入一个接口Comparator实现定制排序
        //Arrays.sort(integers);  //默认排序的代码

        //定制排序如下：
        //定制排序的要求如下：
        //1.传入一个数组 2.实现接口Comparator的匿名内部类
        //体现了接口编程的思想，通过匿名内部类+动态绑定机制来实现
        Arrays.sort(integers, new Comparator/*<Integer>*/() {  //注释的部分表示泛型,使用了一个匿名内部类
            @Override
            public int compare(Object o1, Object o2) {
                //首先进行一个向下转型
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                //i1 - i2是从小到大排序
                //i2 - i1是从大到小排序
                return i1 - i2;
            }
        });
        System.out.println("排序后的数组为：====");
        System.out.println(Arrays.toString(integers));
    }
}
