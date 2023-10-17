package com.chapter08.homework.five_;

import java.util.Scanner;

/*   编程题
     1.有一个交通工具接口类Vehicles，有work接口
     2.有Horse类和Boat类分别实现Vehicles
     3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
     4.有Person类，有name和Vehicles属性，在构造器中为这两个属性赋值
     5.实例化Person对象为"唐僧"，要求一般情况下用Horse作为交通工具，遇到大河的时候用Boat作为交通工具
 */
public class HomeWork {
    private String name;
    public Vehicles vehicles;

    public HomeWork(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
        CreatTransform creatTransform = new CreatTransform();
        System.out.println(this.name);
        creatTransform.obtain(vehicles);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean loop = true;
        do{
            System.out.println("请输入当前是要过河还是代步 g/d/e");
            char ch = myScanner.next().charAt(0);
            if(ch == 'g'){
               HomeWork homeWork = new HomeWork("唐僧",new Horse());
            } else if (ch == 'd') {
                HomeWork homeWork = new HomeWork("唐僧",new Boat());
            }else{
                loop = false;
            }
        }while(loop);
    }
}


interface Vehicles{
    public void work();
}

class Horse implements Vehicles{

    @Override
    public void work() {
        System.out.println("使用马儿来代步");
    }
}

class Boat implements Vehicles{

    @Override
    public void work() {
        System.out.println("使用小船来过河");
    }
}

//和老师的代码对比可以发现：
//调用接口的函数要观察你想要它实现的作用:是实现函数的调用者还是实现函数的传递者
//1.如果是调用者，那么写一个方法，形参为接口类
//2.如果是传递者，那么就写一个方法返回类型为你要返回的实现接口的类
class CreatTransform{
    public void obtain(Vehicles vehicles){
        vehicles.work();
    }
}
