package com.object.equal_;

public class EqualsExercise02 {
    public static void main(String[] args) {
        Person_ person1 = new Person_();
        Person_ person2 = new Person_();
        person1.name = "szm";
        person2.name = "szm";
        System.out.println(person1 == person2);  //输出结果是flase，因为对于引用数据类型，比较的是地址
        System.out.println(person1.name.equals(person2.name));//输出结果是true，因为euqals重写了Object中的方法
        //此时比较的是内容，所以输出结果是ture
        System.out.println(person1.equals(person2)); //输出结果为false，因为Person中没有重写equals方法，此时
        //调用的是Object中的方法，Object中默认是比较地址，因此输出结果为false
    }
}

class Person_{
    public String name;
}
