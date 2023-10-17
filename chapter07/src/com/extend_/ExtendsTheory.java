package com.extend_;

public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();//内存布局如笔记所示
        System.out.println(son.name); //此时是访问谁的名字(Gradepa Father 还是 Son )
        //结论：此时按照查找关系来返回信息
        //(1) 首先看子类是否有该属性
        //(2)如果子类有这个属性，并且可以访问，则返回信息,如果不可以访问，则会报错(此时不会向上找父类的信息)
        //(3)如果子类没有这个属性，则向上找父类有没有这个属性，如果父类有该属性，并且可以访问，就返回信息
        //(4)如果父类没有这个属性就按照(3)的规则，继续找上级父类，直到Object，如果都没有，就会报错
    }
}

class Gradepa{
    String name = "大头爷爷";
    String hobby = "旅游";
    int age = 70;
}

class Father extends Gradepa{
    String name = "大头爸爸";
    //假设我想通过son对象来访问age,此时我发现Father 类中的age是私有的，但是Gradepa中的age是公有的
    //此时我会跳过Father 中的age去访问Gradepa中的age吗？答案是不会
    //因为我已经在Father中找到age类，就不会再去向上访问了
    private int age = 39;
}

class Son extends Father{
    //private String name = "大头儿子";内存中是有这个变量的，只是不能访问
    String name = "大头儿子";
}
