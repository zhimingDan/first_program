package com.chapter09.enum_self;

//自定义枚举类型的步骤
//1.将构造器设置为私有的，这样可以防止外部直接创建对象
//2.将类中的setXxx方法全部去除，防止属性值被修改
//3.提前在类中创建好相关的对象，并且引用的类型为static，这样外部就可以直接调用
public class EnumerationSelf {
    public static void main(String[] args) {
        //因为Season类中的实例都是static类型，因此可以直接通过类名来调用

        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.FALL);
        System.out.println(Season.WINTER);
    }
}

class Season{
    private String name; //季节的名字
    private String desc; //季节的描述

    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season FALL = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    private Season(String name, String desc) { //设置私有的构造器，防止外界直接访问
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() { //返回当前对象的信息
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
