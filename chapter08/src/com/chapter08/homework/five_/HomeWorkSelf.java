package com.chapter08.homework.five_;


/*   编程题
     1.有一个交通工具接口类Vehicles，有work接口
     2.有Horse类和Boat类分别实现Vehicles
     3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
     4.有Person类，有name和Vehicles属性，在构造器中为这两个属性赋值
     5.实例化Person对象为"唐僧"，要求一般情况下用Horse作为交通工具，遇到大河的时候用Boat作为交通工具
 */

public class HomeWorkSelf {
    public static void main(String[] args) {
        Person1 person1 = new Person1("Mr.jack", new Creat().getHorseSelf());
        person1.getVehiclesSelf().work();
    }
}

interface VehiclesSelf{
    public void work();
}

class HorseSelf implements VehiclesSelf{ //定义的HorseSelf类实现了接口，相当于个实现接口的类
    @Override
    public void work() {
        System.out.println("一般情况下，采用马儿代步");
    }
}

class BoatSelf implements VehiclesSelf{ //定义的BoatSelf类实现了接口，相当于个实现接口的类
    @Override
    public void work() {
        System.out.println("遇到河流的时候，采用小船过河....");
    }
}

class Creat{
    public HorseSelf getHorseSelf(){
        return new HorseSelf();
    }
    public BoatSelf getBoatSelf(){
        return new BoatSelf();
    }
}

class Person1{
    private String name;
    private VehiclesSelf vehiclesSelf;

    public Person1(String name, VehiclesSelf vehiclesSelf) {
        this.name = name;
        this.vehiclesSelf = vehiclesSelf;
    }

    public VehiclesSelf getVehiclesSelf() {
        return vehiclesSelf;
    }
}
