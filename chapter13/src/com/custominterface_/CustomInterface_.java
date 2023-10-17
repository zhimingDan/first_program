package com.custominterface_;


public class CustomInterface_ {
}


//其实也可以不用直接在子类实现中指定父接口或者父类的泛型，可以让子类的泛型的字母和父类或者父接口的泛型字母一样，这样也可以
interface IA extends IUsb<String , Double>{//这里必须实现父类接口的泛型，如果不指定，则默认是Object

}

//如果此时有一个类实现了上面的接口
//可以发现，子类中会自动将IUsb中的泛型，用父类接口IA中给定的类型进行填充
class C implements IA{

    @Override
    public void f(String s, Double aDouble) {

    }

    @Override
    public String method(String s, Double aDouble) {
        return null;
    }
}
interface IUsb<R,T>{
    //下面这样的定义是错误的，因为接口中所有的成员都默认是静态的
    //R r;

    //定义一个抽象方法
    void f(R r,T t);

    R method(R r, T t);
}
