package com.debug_;
//动态绑定机制
public class DebugDynamic {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A{
    public int i = 10;
    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 20;
    }
    public int getI(){
        return i;
    }
}

class B extends A{
    public int i = 20;
    public int sum(){
        return i + 10;
    }
    public int sum1(){
        return i;
    }
    public int getI(){
        return i + 10;
    }
}
