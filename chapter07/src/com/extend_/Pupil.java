package com.extend_;

//创建一个小学生类,并继承学生类
public class Pupil extends Student{

    public Pupil(){
        System.out.println("子类的Pupil()被调用");
    }
    public Pupil(String name){
        this();//有结论可以得知，要是写了子类的构造器调用，那么不能写父类的有参构造器调用即super语句
        //但是无参构造器还是会被默认调用的，且一定在子类构造器调用的前面
    }
    public void testing(){

        System.out.println("学生：" + name + "正在进行小学数学考试");
    }
}
