package com.packagestudy;

public class Test {
    public static void main(String[] args) {
       A a = new A();
       a.m1();//全部都可以访问：因为我调用的是A类中的方法，而A类中的方法m1和(private变量是在同一个类中)，
        // 且m1方法是public的，是公开的。
        //我也可以调用n1,n2,n3但是不能调用n4，因为n1,n2,n3所在的A类和Test类在同一个包中，因此我可以调用这些成员变量
        //但是n4是不能调用的，因为n4是private修饰的，只能在本类中调用
        System.out.println(a.n1);
        System.out.println(a.n2);
        System.out.println(a.n3);
        //System.out.println(a.n4); 不能访问私有的
    }
}
