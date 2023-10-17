package com.chapter08.single_;


//单例模式中----->饿汉式
public class SingleTon01 {
    public static void main(String[] args) {
        //创建一个实例来接收这个对象即可，且外部不论创建多少个实例，都是指向同一个空间，因此可以防止外部用户创建实例
        GirlFriend gf1 = GirlFriend.getInstance();

    }
}

class GirlFriend{

    private String name;
    //提前将对象创建好，这样用户只能使用这个提前创建好的对象，将对象私有化的目的是，外部只能使用自己包装的方法来调用
    //这样可以在包装的方法中加入自己需要的逻辑
    private static GirlFriend gf = new GirlFriend("marry");

    //将构造器私有化，可以防止用户创建新的对象
    private GirlFriend(String name) {
        this.name = name;
    }

    //为什么要用static 的原因？
    //虽然使用普通方法也可以调用静态的属性，但是如果使用普通的方法的话，用户就必须创建一个对象才能用这个普通的方法
    //而创建对象的构造器已经被私有化了，外部不能直接创建对象。因此采用静态的方法，外部直接使用类名来直接调用这个方法
    public static GirlFriend getInstance(){ //对外暴露一个方法，使得外部可以使用这个原本就创建好的对象
        return gf;
    }

    public String toString(){

        return "name" + this.name;
    }
}
