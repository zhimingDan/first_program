package com.chapter08.homework.seven_;

/*   编程题：枚举类
     1.创建一个Color枚举类
     2.有一个RED,BLUE,YELLOW,GREEN这个五个枚举值/对象
     3.Color对象有三个属性redValue,greenValue,blueValue
     4.创建构造方法，参数包括这三个属性
     5.每个枚举值都要给这三个属性赋值，三个属性的值分别为：
     red 255,0,0  black 0,0,0 yellow 255,255,0  green 0,255,0
     6.定义接口，里面有方法show，要求Color实现接口
     7.show方法中显示三属性的值
     8.将枚举对象在switch语句中匹配使用
 */
public class HomeWork {
    public static void main(String[] args) {
         Color green = Color.GREEN;
         green.show();
         switch (green){
             case RED : System.out.println("匹配失败");break;
             case GREEN : System.out.println("匹配成功");break;
             default : System.out.println("没有匹配到该颜色");
         }
    }
}


interface IA{
    void show();

}
enum Color implements IA{
    RED(255,0,0),BLUE(0,0,0),
    YELLOW(255,255,0),GREEN(0,255,0);

    private double redValue;
    private double greenValue;
    private double blueValue;

    Color(double redValue, double greenValue, double blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }


    @Override
    public void show() {
        System.out.println("三基调分别为：" + this.redValue + " " + this.blueValue + " " + this.greenValue);
    }

}