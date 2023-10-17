package com.chapter07.exercise01;

//要求：定义一个Person类{name,age,job},初始化Person对象数组，有三个Person对象，并按照age从大到小进行排序(使用冒泡排序)
public class HomeWork01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];  //数组的类型是Person类，因此里面的元素都是Person类的引用，但是没有创建对象
        person[0] = new Person("jack",20,"java");
        person[1] = new Person("marry",15,"student");
        person[2] = new Person("mark",54,"teacher");
        Person person1 = null;

        //如果是按照名字的长度从小到大排序的话，读取名字长度的方法是getName().length 因为名字是String类型
        // 也是一种引用类型
        for (int i = 0; i < person.length -1 ; i++) {  //外层循环是数组的长度-1
            for (int j = 0; j < person.length - i -1; j++) {
                if(person[j].getAge() < person[j+1].getAge()){
                    person1 = person[j+1];
                    person[j+1] = person[j];
                    person[j] = person1;
//                    num = person[j+1].getAge();
//                    person[j+1].setAge((person[j].getAge()));  //这一行代码实现的功能一定要注意
//                    person[j].setAge(person[j+1].getAge());
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]); //重写toString方法，一次来做到输出类中的属性信息
        }
    }
}
