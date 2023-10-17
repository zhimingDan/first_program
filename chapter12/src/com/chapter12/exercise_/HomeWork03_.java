package com.chapter12.exercise_;

import java.util.HashSet;
import java.util.Objects;

//仔细思考一下代码：
//一直Person类已经按照id和name重写了hashCode以及equals方法了
public class HomeWork03_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person person1 = new Person("1001", "AA");
        Person person2 = new Person("1002", "BB");
        hashSet.add(person1);
        hashSet.add(person2);
        //这里改了person1对象中的name属性
        person1.name = "CC";

        //导致这里删除的时候并不会删除成功，因为删除操作也是按照hashCode来进行索引删除的
        //改变了person1对象的一个属性，会导致找到的索引不一定是person1对象所在的位置
        hashSet.remove(person1);

        //因此这里还是会输出两个对象
        System.out.println(hashSet);

        //这里进行添加的时候，也是按照hashCode值去寻找索引的位置的，这个索引位置和person1中的索引是不一样的
        //因此这里也会添加成功
        hashSet.add(new Person("1001","CC"));
        System.out.println(hashSet);

        //这里找到的是person1的索引位置，但是此时person1中的属性已经改变了，因此equals方法进行判断的时候
        //会发现两者并不相等，因此这个会添加到person1的后面形成一个链表
        hashSet.add(new Person("1001","AA"));
        System.out.println(hashSet);
    }
}

class Person{
    public String id;
    public String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
