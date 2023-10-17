package com.extendexercise;

//练习：编写一个Computer类，包含CPU，内存，硬盘等属性，getDetails方法用于返回Computer的详细信息
//编写一个PC子类，继承Computer类，添加特有属性(品牌brand)
//编写NotePad子类，继承Computer类，添加特有属性(color)
//编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值
// 以及从Computer类中继承的属性赋值，并使用方法打印输出
public class ExtendsExercise {
    public static void main(String[] args) {
//        PC pc = new PC("stc89","legion",4096,"无");
//        //NotePad notePad = new NotePad("stc89","白色",4096,"无");
//        pc.showInfo();
//        //notePad.showInfo();
        NotePad notePad = new NotePad();
        System.out.println(notePad.n1);
        System.out.println();
    }
}

class Computer{
    public String cpu;
    private double internal;
    private String hardDisk;
    public int n1 = 100;
    public Computer(){}

    public Computer(String cpu ,double internal,String hardDisk){ //通过构造器对父类的属性进行初始化
        this.cpu = cpu;
        //this.setInternal(internal);  //本类中调用本类的私有属性是可以直接赋值的，而不是通过setXxx这样的设置函数
        //this.setHardDisk(hardDisk);
        this.internal = internal;
        this.hardDisk = hardDisk;
    }

    public double getInternal() {
        return internal;
    }

    public void setInternal(double internal) {
        this.internal = internal;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }
}

class PC extends Computer{
    public String brand;
    public int n1 = 200;
    public PC(){

    }
    public PC(String cpu,String brand,double internal,String hardDisk){
        super(cpu , internal , hardDisk); //父类的属性由父类的构造器完成初始化
        this.brand = brand; //子类的属性由子类完成初始化
    }
    public void showInfo(){
        System.out.println("cpu:" + cpu + "brand:" + brand + " internal:" + getInternal() + " hardDisk:" + getHardDisk());
    }
}

class NotePad extends PC{
    public String color;
    public int n1 = 300;
    public void showInfo(){
        System.out.println(super.n1);
    }
    public void showInfo2(){
        //System.out.println(super.super.n1);  不能使用两个super来越级调用
    }
//    public NotePad(String cpu,String color,double internal,String hardDisk){
//        super(cpu , internal , hardDisk);
//        this.color = color;
//    }
//    public void showInfo(){
//        System.out.println("cpu:" + cpu + "color:" + color + " internal:" + getInternal() + " hardDisk:" + getHardDisk());
//    }
}
