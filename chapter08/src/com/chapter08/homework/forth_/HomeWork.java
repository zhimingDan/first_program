package com.chapter08.homework.forth_;

/*   编程题
     1.编写一个类A ,在类中定义局部内部类B，B中有一个私有的常量name,有一个show()方法打印并测试
     2.进阶：A中也有一个私有变量name，也在show()方法中打印
 */

//局部内部类的探究：局部内部类一般是创建在方法中，执行方法的时候实际上是不会执行这个局部内部类的
//因此，一般会在方法中实例化这个局部内部类，然后调用局部内部类中的成员

//局部内部类其实很简单：因为局部内部类定义在方法中，因此想要调用局部内部类中的方法，必须先要在方法中
//实例化局部内部类，为了调用这个方法，需要在外边其他类中实例化这个外部类，然后通过外部类去调用这个方法
public class HomeWork {
    public static void main(String[] args) {
        A a = new A();
        a.showOuter();
    }
}

class A{
    private String name = "小蓝";
    public void showOuter(){
        class B{
            private final String NAME = "小红";
            public void showInner(){
                System.out.println("内部名字为：" + NAME + "  外部名字为：" + A.this.name);
            }
        }
        B b = new B();
        b.showInner();
    }
}
