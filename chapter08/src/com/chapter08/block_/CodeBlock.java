package com.chapter08.block_;
//研究代码块的使用
public class CodeBlock {
    public static void main(String[] args) {
        Movie movie1 = new Movie("jack");
        Movie movie2 = new Movie("jack",1000);

        System.out.println("========================================");
        //此时创建一个子类对象的时候，一定先加载父类，因此父类的代码块被先调用(不论有没有static，都会被优先调用)
        BB bb = new BB();
        //创建一个子类对象，但用父类接收时，是一样的结果
        System.out.println("========================================");
        AA aa = new BB();

    }
}

class Movie{
    private String name;
    private double price;
    private String director;


    //从以下所有的构造器中可以发现，构造器中都调用了相同的语句，这时候，可以考虑使用代码块对这些
    //语句进行统一的管理，以实现代码块的复用(因为代码块不论是静态代码块还是普通代码块的调用，都是先于构造器调用的)
    //且普通代码块每次创建一个对象后，都会调用一次代码块中的语句,而静态代码块只有类加载的时候会被调用一次，创建对象的
    //时候是不会重复调用的，因为不管创建多少个对象，类加载相当于加载类的模板，因此类加载只有一次
    static{
        System.out.println("电影正在制作");
        System.out.println("电影制作完成");
        System.out.println("电影开始放映");
    }
    public Movie(String name) {
//        System.out.println("电影正在制作");
//        System.out.println("电影制作完成");
//        System.out.println("电影开始放映");
        System.out.println("构造器1正在被调用");
        this.name = name;
    }

    public Movie(String name, double price) {
//        System.out.println("电影正在制作");
//        System.out.println("电影制作完成");
//        System.out.println("电影开始放映");
        System.out.println("构造器2正在被调用");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
//        System.out.println("电影正在制作");
//        System.out.println("电影制作完成");
//        System.out.println("电影开始放映");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}

class AA{
     static {
        System.out.println("AA的代码块被执行");
    }
}

class BB extends AA{
     static {
        System.out.println("BB的代码块被执行");
    }
}