package com.chapter08.homework.five_;


/*   编程题
     1.有一个交通工具接口类Vehicles，有work接口
     2.有Horse类和Boat类分别实现Vehicles
     3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
     4.有Person类，有name和Vehicles属性，在构造器中为这两个属性赋值
     5.实例化Person对象为"唐僧"，要求一般情况下用Horse作为交通工具，遇到大河的时候用Boat作为交通工具
 */

//理解老师的编程思想

public class HomeWorkPro {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse1()); //这样就是直接调用对应的方法
        //但是要考虑过河和走路的情况
    }
}

interface Vehicles1{
    public void work();
}

//以下两个类，相当于接口的实现类
class Horse1 implements Vehicles1{

    @Override
    public void work() {
        System.out.println("一般情况下，使用马儿代步");
    }
}

class Boat1 implements Vehicles1{
    @Override
    public void work() {
        System.out.println("遇到河流的时候，使用船过河");
    }
}

//创建一个类，来调用接口

//为什么不直接使用我写的代码？
//写代码的时候，一定要分析自己要做什么
//实现接口的类不用说，就只是单纯的去实现接口中的方法，但是调用接口的类中就大有不同
//调用接口的类需要完成什么任务，到底是在调用接口的时候返回实现接口的类型，然后由其他的类通过返回的类型调用不同的方法
// 还是直接在调用接口的方法中直接实现调用不同的方法，这是两个不同的事情
//需要注意的一点：如果不想创建对象来调用类中的成员，就一定要把类中的成员静态化
class VehiclesFactory{
    //调用接口的类，我并不想创建对象才能调用，因此可以把其中的方法设置为static方法
    //此时还是有一个问题：因为马在走的过程中是不变的，而船是变化的，此时可以考虑采用单例设计模式中的饿汉式

    private static Horse1 horse1 = new Horse1(); //提前创建好对象

    private VehiclesFactory(){}//将构造器私有化，防止手动创建对象
    public static Horse1 getHouse(){
        return horse1;
    }

    public static Boat1 getBoat(){
        return new Boat1();
    }

}

class Person{
    private String name;
    private Vehicles1 vehicles1;

    public Person(String name, Vehicles1 vehicles1) {//对象的类型，关键看传入的对象
        this.name = name;
        this.vehicles1 = vehicles1;
    }

    public void passRiver(){
        if(!(vehicles1 instanceof Boat1)){ //调用方法的时候，进行对象的判断，如果当前对象不是船的话，我们改变对象
            vehicles1 = VehiclesFactory.getBoat();
        }
        vehicles1.work();  //使用多态的方式来调用具体的方法
    }

    public void walk(){
        if(!(vehicles1 instanceof Horse1)){ //调用方法的时候，进行对象的判断，如果当前对象不是船的话，我们改变对象
            vehicles1 = VehiclesFactory.getHouse();
        }
        vehicles1.work();
    }
}
