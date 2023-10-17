package com.chapter08.abstract_exercise;

public abstract class Temple {

    //实际上就是抽象类中的普通方法不能直接实现，而是依赖于子类中对抽象方法的重写来实现的
    //可以把子类中都要实现的方法中公共的部分提取出来到父类中来当做模板，方法中不同的方法则依赖于子类的具体实现
    public  void calculate(){
        long start = System.currentTimeMillis();
        job(); //当方法执行到这里的时候，是会遵守动态绑定机制的,一定要记住动态绑定机制
        long end = System.currentTimeMillis();
    }
    public abstract void job();  //设计一个抽象的方法，这样子类不同的方法就是一个不同的模板
}
