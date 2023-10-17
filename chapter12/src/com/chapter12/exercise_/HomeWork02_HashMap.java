package com.chapter12.exercise_;

import java.util.HashMap;
import java.util.Set;

/*  按要求完成下列任务：
    1.使用HashMap类实例化一个Map类型的对象m，键(String) 和值(int) 分别用于存储员工的姓名和工资
    存储的数据如下: jack - 650元; tom - 1200元; smith - 2900元
    2.将jack的工资更改为2600元
    3.为所有员工工资加薪100元
    4.遍历集合中所有的员工
    5.遍历集合中所有员工的工资
 */
public class HomeWork02_HashMap {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);

        //将jack的工资更改为2600元
        hashMap.put("jack",2600);
        //遍历集合中所有的员工
        Set keySet = hashMap.keySet();
        for (Object o : keySet) {
            //为所有员工的工资加薪100,使用的还是替换的方法
            hashMap.put(o,(Integer)hashMap.get(o) + 100);
            System.out.print(o);
            //遍历集合中所有员工的工资
            System.out.println("- >" + hashMap.get(o));
        }
    }
}

