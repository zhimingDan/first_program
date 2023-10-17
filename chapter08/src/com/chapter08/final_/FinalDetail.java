package com.chapter08.final_;

//final关键字的细节说明
public class FinalDetail {
    public static void main(String[] args) {

        //可以很明显的看到，当执行上面这个静态的final属性时，系统是不会执行静态代码块的，说明系统没有进行类加载
        //因此效率更高
        System.out.println(BBB.NUM1);


        //而对于没有加final的静态代码块而言，系统是需要进行类加载的，从而对属性进行初始化，因此效率要低一些
        System.out.println("=======================");
        System.out.println(BBB.num2);
    }
}

class AA{
    //对于final属性，赋值的方式只有三种:1.定义的时候赋值 2.在构造器中赋值 3.在代码块中赋值(因为代码块相当于构造器的扩展)
    public final double RATE = 0.1;
    public final double RATE1;
    public final double RATE2;

    //对于静态的final属性，可以初始化的地方只有:1.定义的时候 2.静态代码块中
    public static final double RATE3 = 0.5;
    public static final double RATE4;
    //在构造器中是无法赋值的，因为构造器是在创建对象的时候才会开始初始化，而静态变量则是需要类加载的时候开始初始化，因为无法在构造器中给静态变量赋值

    public AA() {
        //RATE = 0.2; //可以发现，构造器和代码块中并不是可以修改final类型的值，而是进行初始化
        //final类型的变量一旦进行初始化后，就再也不能再次修改其中的值
        RATE1 = 0.3;
    }
    {
        RATE2 = 0.4;
    }
    static {
        RATE4 = 0.6;
    }
}


class BBB{
    public static final int NUM1 = 1;
    public static int num2 = 0;
    static {
        System.out.println("静态代码块被执行");
    }

    public int addOne(final int x){
        //x++;  //这句话是错误的，因为x是final类型的，所以不能改变
        return x+1; //但是这句话是正确的，因为只是返回一个值，实际上并没有改变x的值
    }
}