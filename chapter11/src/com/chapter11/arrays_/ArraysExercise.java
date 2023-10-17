package com.chapter11.arrays_;

import java.util.Comparator;

//练习要求如下：
//定义一个Book类，里面包含name以及price属性，按照price进行排序，既可以从大到小，也可以从小到大排序
//使用定制排序以及匿名内部类来完成
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("java从入门到放弃", 300);

//        //方法1：使用Arrays提供的sort方法定制排序
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                //这里是对Book进行排序，因此Object中的对象就是Book
//                Book num1 = (Book)o1;
//                Book num2 = (Book)o2;
//                //return (int) (num1.getPrice() - num2.getPrice());
//                // 这样强制转换是不行的，因为如果两个数相差很小的话(只有小数的差异)，那么强制转换就会把它变成0
//                //此时该比较方法就会误判,因此不能这样返回
//                if(num1.getPrice() - num2.getPrice() > 0){
//                    return -1;
//                }else if(num1.getPrice() - num2.getPrice() < 0){
//                    return 1;
//                }else{
//                    return 0;
//                }
//            }
//        });
//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i]);
//        }

        //方法2:自己使用冒泡排序来定制
        bubble(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                double num1 = (Double) o1;
                double num2 = (Double) o2;
                return (int) (num1 - num2);
            }
        });

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public static void bubble(Book[] books, Comparator c) {
        Book temp;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j].getPrice(), books[j+1].getPrice()) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "书名：" + name + " 价格：" + price;
    }
}
