package com.object.equal_;


//finalize方法在实际开发中几乎不会使用，基本上只是为了应对面试

public class Finalize_ {
    public static void main(String[] args) {
        Car bmw = new Car("bmw");
        //这时Car对象就是一个垃圾，垃圾回收机制会对其进行回收，在回收该对象之前会调用该对象的finalize方法
        //此时程序员可以在finalize方法中，添加自己的业务逻辑，例如:释放资源(数据库的连接，打开文件等)
        //如果程序员不重写finalize方法，那么程序就会自动调用Object中的finalize方法，即默认处理
        //如果程序员重写了finalize方法，那么程序员就可以实现自己的逻辑
        bmw = null;  //将这个引用置为空，此时没有任何引用指向前面创建的对象
        //并不是说该对象变成了一个垃圾，垃圾回收机制就会直接将其回收，而是有一套算法

        //主动调用垃圾回收器
        System.gc(); //但不是一定会运行，是有一定的概率的
        //程序并不会堵在这里
        System.out.println("程序退出了");
    }
}

class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        //super.finalize(); //默认情况调用父类的
        System.out.println("销毁了汽车，释放了资源" + this.name);
    }
}
