package com.polyarray;

public class PloyArry {
    public static void main(String[] args) {
        Person[] person = new Person[5];  //定义一个Peron类型的数组，里面的数据类型都是Person类型
        //因为Person是父类类型，是可以指向子类的
        //下列就是利用多态中的向上转型，左边的编译类型是Person,右边的运行类型是子类类型
        //引用分别指向了不同类型的对象
        //此时数组中的每个变量都是一个引用
        person[0] = new Person("jack",20);
        person[1] = new Student("tom",20,90);
        person[2] = new Student("jerry",23,99);
        person[3] = new Teacher("mark",35,10000);
        person[4] = new Teacher("sandwich",40,20000);

        //调用say()方法，可以利用循环来进行调用
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say());//一定要时刻注意动态绑定机制(调用方法的时候，一定要注意引用的运行类型)
            //如何调用子类中特有的方法？利用向下转型
            if(person[i] instanceof Student) {//判断数组的运行类型是否是Student类型，如果是，就向下转型
                //方法一：
//                Student stu = (Student)person[i];
//                stu.study();
                //代码优化
                ((Student)person[i]).study();
            }else if(person[i] instanceof Teacher){
                ((Teacher)person[i]).teach();
            }else{
                System.out.println("你输入的类型有误");
            }
        }
    }
}
