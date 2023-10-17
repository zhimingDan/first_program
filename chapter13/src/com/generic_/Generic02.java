package com.generic_;

import java.util.*;

/*  练习：(举例说明泛型在HashSet以及HashMap中的使用)
    1.创建3个学生对象
    2.分别放入到HashSet以及HashMap中，并要求Key是String Value就是学生对象
    3.使用两种方式遍历

 */
public class Generic02 {
    public static void main(String[] args) {
        //首先使用HashSet来存放
        //如果指定了泛型，那么存放的类型只能是这个类型或者这个类型的子类型，不能是其他的类型
        HashSet<Student> strings = new HashSet();
        strings.add(new Student("jack", 20));
        strings.add( new Student("tom", 30));
        strings.add(new Student("rose", 18));

        //遍历方式一：采用增强for进行遍历
        System.out.println("HashSet的遍历方式一：采用增强for进行遍历");
        //因为里面的类型是确定的，因此这里可以直接采用相应的类型去接收
        for (Student s : strings) {
            System.out.println(s);  //调用toString方法
        }

        System.out.println("HashSet的遍历方式二：采用迭代器进行遍历");
        Iterator<Student> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //使用HashMap来存放,HashMap是双值集合，因此有两个泛型
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put("jack", new Student("jack", 20));
        hashMap.put("tom", new Student("tom", 30));
        hashMap.put("rose", new Student("rose", 18));

        //使用entrySet进行遍历
        //表示取出的类型是Map.Entry类型,且Map.Entry类型中的K-V分别是：String 和 Student
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        System.out.println("HashMap的遍历方式一：采用增强for进行遍历");
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", age=" + age;
    }
}
