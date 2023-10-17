package com.chapter12.map_;

import java.util.*;

//Map接口中所有的遍历方式
@SuppressWarnings({"all"})
public class MapFor_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋泽","马蓉");
        map.put("刘凌波",null);
        map.put(null,"刘亦菲");
        map.put("鹿晗","关晓彤");
        //第一组：先取出所有的键值(key)，然后通过键值(key)，取出所有的value
        Set keySet = map.keySet();
        //因为此时keySet是编译类型是Set类型的，而Set类型有两种遍历方式：增强for  和  迭代器iterator
        //(1)增强for
        System.out.println("===============方式一===============");
        for (Object o : keySet) {
            System.out.println(o + " -> " + map.get(o));
        }

        //(2)使用迭代器iterator
        Iterator iterator = keySet.iterator();
        //此时是从keySet中拿到键值
        System.out.println("===============方式二===============");
        while (iterator.hasNext()) {
            Object o =  iterator.next();
            System.out.println(o + " -> " + map.get(o));
        }

        //第二组：把所有的values取出来
        Collection values = map.values();
        //可以看到values是Collection类型，因此可以使用Collection中所有的遍历方法：
        //增强for  迭代器iterator
        System.out.println("===============方式三===============");
        for (Object o :values) {
            System.out.println(o);
        }

        System.out.println("===============方式四===============");
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        //第三组：使用EntrySet来取出K - V
        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object o :set) { //此时o的运行类型是Entry类型,但是Entry是Map中的一个静态内部类，不能直接访问，
            // 因此需要用类名.内部类名的形式来调用

             Map.Entry entry = (Map.Entry) o;//只有向下转型，才能调用子类中独有的方法
             //然后entry中提供了重要的方法getKey() 以及 getValue()方法
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //使用迭代器iterator
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next(); //next的编译类型是：HashMap$Node -- 实现了 -->Map.Entry(getKey,getValue)
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
