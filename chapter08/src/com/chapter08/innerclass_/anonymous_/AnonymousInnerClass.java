package com.chapter08.innerclass_.anonymous_;

// 匿名内部类的使用
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer {//定义一个外部类
    private int n1 = 100;

    public void method() {
        //基于接口的匿名内部类
        //需求：向使用IA接口，并创建对象
        //传统的方法:写一个类，实现该接口，并且创建对象
//        IA tiger = new Tiger(); //使用接口多态
//        tiger.cry();//利用动态绑定机制，调用Tiger类中的方法

        //但是如果对于Tiger类我只想用一次，用一次以后就再也不会使用了，那么我写一个Tiger类就有点浪费
        //解决的方法----->使用匿名内部类来简化开发

        //tiger的编译类型是什么？---->很明显，编译类型是IA
        //tiger的运行类型是什么？---->但是这里的运行类型却不是IA,而是匿名内部类
        /**
         * 实际上底层的代码会发生如下的事情：
         * class Outer$1 implements IA{
         *     public void cry(){
         *        System.out.println("老虎嗷嗷叫");
         *     }
         * }
         */
        //jdk底层相当于在创建匿名内部类Outer$1的时候，就立马给对象Outer$1分配了空间
        //然后将空间的地址返回给了tiger实例，匿名内部类使用了一次就不能使用了
        IA tiger = new IA() {  //此时后面的类体中的部分就相当于老虎类中的类体中的部分
            public void cry() {
                System.out.println("老虎嗷嗷叫");
            }

        };
        tiger.cry(); //调用上面类体中实现的cry方法，这个时候得到的效果和前面的效果是一样的
        System.out.println("匿名内部类的名称" + tiger.getClass()); //可以得到引用的运行类型的类名

        //演示匿名内部类：
        //此时
        //father的编译类型为：Father
        //father的运行类型为：Father
        Father father = new Father("tom");

        //但是，如果后面加了{}时，此时就不一样了
        //此时
        //father的编译类型为：Father
        //father的运行类型为：Outer$2
        //这个参数列表会自动传递给Father类的构造器！！！！而不是传递给抽象类中的构造器

        Father father1 = new Father("jack") {

            //！！！！！

        }; //因为Father这类中的方法都已经实现了，因此此时类体中可以什么都不写

        //以下是一种调用匿名内部类的方法之一
        Animal dog = new Animal() { //如果是抽象的类，那么一定要实现其中的方法
            @Override
            void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        dog.eat();
        //调用匿名内部类的方法二：
        new Animal() { //如果是抽象的类，那么一定要实现其中的方法
            @Override
            void eat() {
                System.out.println("直接调用的方法");
            }
        }.eat();
    }

}

interface IA { //定义一个接口
    public void cry();
}

//class Tiger implements IA{
//
//    @Override
//    public void cry() {
//        System.out.println("老虎嗷嗷叫.....");
//    }
//}

class Father {
    public Father(String name) {
        System.out.println("名字为 ：" + name);
    }

    public void test() {

    }
}

abstract class Animal {
    abstract void eat();
}
