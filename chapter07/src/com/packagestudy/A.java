package com.packagestudy;

public class A {
    //四个属性，分别使用不同的访问修饰符来修饰
    public int n1 = 100;
    protected int n2  = 200;
    int n3 = 300;
    private int n4 = 400;
    public void m1(){
        //该方法中可以访问四个属性
        System.out.println("n1=" + n1);
        System.out.println("n2=" + n2);
        System.out.println("n3=" + n3);
        System.out.println("n4=" + n4);
    }
}
