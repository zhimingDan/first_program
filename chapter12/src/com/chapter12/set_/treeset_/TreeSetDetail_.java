package com.chapter12.set_.treeset_;

import java.util.*;

//探究TreeSet中的细节
public class TreeSetDetail_ {
    public static void main(String[] args) {

        //通过下面的案例可以发现：
        //如果是采用的无参构造器，那么取出的顺序和存入的顺序依然是不相同的
        //这时候可以使用TreeSet提供的有参构造器，利用匿名内部类重写compare方法，以此来达到自定义排序的结果
        //Set set = new TreeSet();
        //一定要注意：TreeSet是否能够输出结果主要是看你的重写的compare方法中的返回值
        //如果返回值是0，那么就底层就会认为这两个值是同一个值，这时候就会出现加入不成功的现象！！！！
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        set.add("jack");
        set.add("tom");
        set.add("marry");
        set.add("jerry");
        set.add("a");
        System.out.println("set" + set);

        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");
        arrayList.add("smith");
        arrayList.add("jerry");
        arrayList.add("marry");

        //ArrayList arrayList1 = new ArrayList(arrayList.size()+1);
        //可以发现：不能直接利用构造器来指定扩容的，因为里面的元素一开始就没有，需要添加元素之后
        //才会按照指定容量进行扩容

        //方式一：
        ArrayList arrayList1 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList1.add("");
        }

        //因为copy方法的源码中会进行原来集合和目的集合的长度的判断，如果目的集合的长度小于原来的集合
        //就会抛出一个异常，因此我们需要先给目的集合扩容到arrayList.size()的长度
        Collections.copy(arrayList1,arrayList);
        System.out.println(arrayList1);
    }
}
