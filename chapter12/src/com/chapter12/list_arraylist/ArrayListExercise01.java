package com.chapter12.list_arraylist;

import java.util.ArrayList;
import java.util.List;

/*  使用List的实现类添加三本图书，并遍历，打印如下效果
    名称：XXX  价格：XXX  作者：XXX
    名称：XXX  价格：XXX  作者：XXX
    名称：XXX  价格：XXX  作者：XXX
    要求按照价格从高到低排序
 */
public class ArrayListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("三国", "罗贯中", 50.2));
        list.add(new Book("红楼梦", "曹雪芹", 80.3));
        list.add(new Book("西游记", "吴承恩", 40.1));
        bubble(list);
        for (Object obj : list) {
            Book book = (Book) obj;
            System.out.println("名称:" + book.getName() + "\t\t\t价格:" + book.getPrice() + "\t\t\t作者:" + book.getAuthor());
        }
    }

    public static void bubble(List list) {
        Object temp;

        //使用冒泡排序
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                //这里必须要进行向下转型，因为是调用子类中特有的方法
                Book obj = (Book) list.get(j);
                Book obj2 = (Book) list.get(j + 1);
                if (obj.getPrice() > obj2.getPrice()) {
                    //temp = list.get(j);
                    //这里可以不需要中间变量就可以实现交换
                    list.set(j, obj2);
                    list.set(j + 1, obj);
                }
            }
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
