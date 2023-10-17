package com.chapter12.collectioniterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//只要java中有方法的调用，自己就一定要联想到动态绑定机制
@SuppressWarnings({"all"})
public class CollectionIterator_ {
    //使用集合的好处就在于能够存储任意多个不同类型的对象，这也是数组的缺点
    public static void main(String[] args) {
        Collection col = new ArrayList();

        //因为add方法是直接传入一个Object对象的
        col.add(new Book("三国演义","罗贯中",50.2));
        col.add(new Book("红楼梦","曹雪芹",80.3));
        col.add(new Book("西游记","吴承恩",40.1));

        //使用迭代器的步骤(因为都是Iteratable的子类，所以都可以使用迭代器来访问集合中的元素)：
        //调用Collection子类中的iterator方法，返回一个Iterator对象。因为子类都实现了接口中的该方法
        Iterator iterator = col.iterator();


        //生成一下while()循环的快捷键：itit 查看所有快捷键的快捷键：ctrl + j
        while (iterator.hasNext()) {//iterator.hasNext()表示访问集合中的下一个元素，如果不是null则返回true
            //iterator只能用于访问集合中的元素，不能用于存储元素
            Object obj =  iterator.next(); //这里obj的编译类型是Object,但是运行类型不是
            System.out.println(obj);//因此这里调用obj的方法的时候，有动态绑定机制，运行的是Book中的toString方法
        }

        //一定要注意: 此时迭代器的游标指向了最后一个位置，后面不能直接使用该迭代器重新遍历
        //如果需要重新遍历，需要重新指向迭代器的首个位置：
        iterator = col.iterator(); //这样就可以重新指向首位置了


        //方式二：使用增强for循环来实现遍历(增强for循环只能遍历数组和集合)
        //快捷方式: I
        //底层仍然相当于一个迭代器iterator,游标会自动回到首位

        System.out.println("===============方式二====================");
        for(Object book : col){
            System.out.println(book);
        }
    }
}


class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}