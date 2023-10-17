package com.chapter09.annotation_.override_;

public class Override_ {
    public static void main(String[] args) {

    }
}

class Father{
    public void fly(){
        System.out.println("father is flying");
    }
}

class Son extends Father{

    //1.Override注解放在方法上面，表示重写了父类的方法
    //2.实际上就算没有Override注解，子类的方法还是重写了父类的方法，编译器会自己去判断
    //3.如果你写了@Override注解，那么编译器就会去检查该方法是否真的重写了父类的方法，如果重写了，编译就会通过
    //如果没有重写的话，编译器就会报错，因此@Override注解的价值在于校验
    @Override
    public void fly() {
        System.out.println("son is flying ");
    }
}
