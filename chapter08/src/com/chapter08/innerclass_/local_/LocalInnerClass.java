package com.chapter08.innerclass_.local_;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer(); //创建一个外部类的对象
        outer.m1();//如果此时没有在方法体中创建对象的时候，可以发现类实际上是不会自动执行其中的方法的
        //也就是说方法中虽然有类体，但是却是不会自动执行的，方法体中会自上而下执行，因此必须在方法体中创建对象
        //然后用对象调用方法体中内部类的方法
    }
}

class Outer{ //定义一个外部类
    private int n1 = 100;
    public void m1(){
        //内部类通常定义在外部类的局部位置：方法体或者代码块中
        class Inner{ //定义一个内部类
            //内部类可以直接调用外部类的所有的属性

            private int n1 = 200;
            public void f1(){
                System.out.println("n1 = " + n1 + "外部类中的n1 = "+ Outer.this.n1);

                //直接调用外部类的方法,这里可以发现方法定义在代码块的下面，这说明类体中是没有顺序的
                m2();


            }
            //无法在类体重直接使用输出函数
            //System.out.println("n1 =" + n1);  //这句话是错误的
        }
        Inner inner = new Inner();
        inner.f1();
    }
    private void m2(){
        System.out.println("Outer的m2方法");
    }
}
