package com.chapter.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Student tom = new Student("tom");
        tom.payFee(100);
        Student jack = new Student("jack");
        jack.payFee(200);//用变量名来调用
        Student.showFee();//用类名来调用
    }
}

class Student{
    public String name;

    //创建一个静态的变量，用于存储所有学生的学费总和
    public static double fee = 0;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name,double fee) {
        this.name = name;
        this.fee = fee; //可以通过构造器来直接进行初始化
    }


    /*
     * 说明：
     * 1.当方法前面用static 修饰时，此时该方法就是静态方法
     * 2.静态方法就可以直接访问静态属性
     */
//    public void payFee(double fee){
//        this.fee += fee;  //在非静态方法中，可以直接使用this.变量名直接访问静态变量
//    }
    public static void payFee(double fee){
        // 静态方法中不允许出现和对象相关的关键字this和super
        //this.fee += fee;  //可以发现在静态方法中，不能直接使用this.变量名来访问静态变量
        Student.fee += fee; //只能使用类名.变量名来访问静态变量
    }

    public static void showFee(){
        System.out.println("总学费为：" + Student.fee);
    }
}
