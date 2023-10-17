package com.threaduse_;


//体验一下静态代理的设计模式
//对静态代理模式的理解：某个类想要实现某个方法，且这个方法的实现依赖于这个类的某个方法，
// 但是这个类中没有这个方法，而别的类中有这个方法
//此时可以利用静态代理模式，创建一个本来的对象，并把本类对象传到其他类的对象中，然后利用其他类的对象
//调用这个方法，在这个方法中利用动态绑定机制来回调那个类中的方法，来带到实现功能的目的

public class ProxyDetail_ {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}


class Animal{}
class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫~~~");
    }
}

class ThreadProxy implements Runnable{ //这里可以把ThreadProxy看做一个Thread

    private Runnable target = null; //利用多态
    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}
