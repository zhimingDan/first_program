package com.chapter08.facetointerface_.factory;


//面向接口编程：简单工厂模式(这种思维的方式特别的重要)，深刻阐述了接口的意义
/**
 *对于工厂模式的理解：
 * 首先必须理解一个点，就是接口是一个作为中间媒介的东西，它有类去实现它，也有类去调用它
 * 因此本程序中的目的是:我需要实现电脑Computer类调用接口来得到数据，或者输出数据的操作
 *
 * 基于以上目的，本程序的编程思想为：
 * 1.定义一个接口，用于作为设计规范。定义其中的输出数据的方法(out()) 和得到数据的方法 getData(String mags)
 * 2.接口只是一个设计规范，我需要类去具体实现它，因此我定义一个Printer类，在Printer类中 implements(实现) 该接口
 * 3.实现接口后，我可以通过多态的方式，在Computer类中调用Printer中具体实现的方法(当然，我也可以不是采用多态的方式，
 * 而是用Printer类的实例来，但是因为一个接口的实现方式有很多中，用多态可以随时调用自己想调用的方法，这也是多态的最大的意义)
 * 4.我可以在调用接口的类(Computer)中定义一个接口的引用，然后在Computer类中通过该引用调用Printer类中的方法
 * 5.我只需要在创建Computer类的构造器的时候，完成接口引用的初始化即可
 * 6.简单工厂模式的好处在于：加入有一天，我打印的方法要改变的时候，我只需要改变创建Computer构造器中，对接口的引用初始化即可
 * 完成对不同的方法实现的调用
 */
public class OutPutFactory {
    public Output getOutPut(){
        return new Printer(); //返回打印类的对象
    }

    public static void main(String[] args) {
        OutPutFactory outPutFactory = new OutPutFactory();
        Computer computer = new Computer(outPutFactory.getOutPut());
        computer.keyIn("三国演义");
        computer.keyIn("水浒传");
        computer.print();
    }
}
