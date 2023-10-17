package com.chapter12.list_arraylist;

import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        //ArrayList的扩容机制：
        //如果使用的是无参构造器创建的ArrayList对象，那么当添加一个元素的时候，ArrayList底层维护的数组就会
        //扩容至10，然后每次满后，就会按照1.5倍来进行扩容
        ArrayList arrayList = new ArrayList();
        //探究一下ArrayList的源代码
        for (int i = 1; i <= 10; i++) {
            arrayList.add(1);
            //虽然创建的数组的后面的元素都是空，但是是不会显示出来的
        }
        //如果扩容的是一个基本数据类型的话，则首先会调用对应应用类型的valueOf()方法，来进行类型转换
        //对于一个数组，因为增删的操作不是特别的方便，如果不是直接调用库函数的话，每次应该首先判断容量够不够
        //是否需要扩容
    }
}
    /*
    //这个函数是实现当数组第一次加入元素的时候，来实现判断功能

    //最开始需要最小数组的大小的个数是minCapacity = 0 + 1 = 1
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { //首先，先判断维护的数组是否是个空数组{}
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);//如果是的话，就令最小的容量变为10和你输入的数字之间的最大值
        }

        ensureExplicitCapacity(minCapacity);
    }

     private void ensureExplicitCapacity(int minCapacity) {
        modCount++; //统计加入元素的次数，防止多线程的时候，造成不安全

        // overflow-conscious code
        //需要的数组大小的个数 - 当前实际数组的大小，如果大于0，代表此时需要扩容了
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
     */
