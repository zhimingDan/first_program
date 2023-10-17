package com.exercise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
    练习：通过反射修改私有成员
    1.定义PrivateTest类，有私有name属性，并且属性值为helloKitty
    2.提供getName共有方法
    3.创建PrivateTest类对象，利用Class类得到私有的name属性，并且修改name属性的值，并调用getName的方法打印name属性的值
 */
public class HomeWork01 {
    public static void main(String[] args) throws Exception{
        Class<?> workClass = Class.forName("com.exercise.PrivateTest");
        Object o = workClass.newInstance();
        Field field = workClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(o,"jack");

        Method method1 = workClass.getMethod("getName");
        System.out.println(method1.invoke(o));

    }
}

class PrivateTest{
    private String name = "helloKitty";

    public PrivateTest(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
