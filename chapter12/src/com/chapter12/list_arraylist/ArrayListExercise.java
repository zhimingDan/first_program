package com.chapter12.list_arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*  要求如下：
    添加10个以上的元素，要求在第二个位置插入一个元素韩顺平教育，获得第五个元素
    删除第六个元素，修改第七个元素，再使用迭代器遍历集合
 */
public class ArrayListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("marry");
        list.add("jerry");
        list.add("merry");
        list.add("mark");
        list.add("dog");
        list.add("cat");
        list.add("mouse");
        list.add(1,"韩顺平教育");
        System.out.println("第五个元素" + list.get(4));
        list.remove(5);
        list.set(6,"mouse");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
}
