package com.chapter08.local_inner;

public class Outer { //外部类
    private int outer_i = 100;

    public void test(){//外部类的方法
        for (int i = 0; i < 5; i++) {

            class Inner{ //这个内部类虽然定义在方法中，但是却不会执行,因为是不会主动执行类体的
                public void display(){
                    System.out.println("display()方法中：" + outer_i);
                }
            }

            Inner inner = new Inner(); //在方法中创建一个对象
            inner.display();//用这个对象来调用内部类中的方法

        }
    }
    //这个例子说明，只有创建了外部对象的实例，才能调用外部对象的方法
    //通过外部对象的方法执行创建内部对象的实例，然后调用内部对象的成员
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
