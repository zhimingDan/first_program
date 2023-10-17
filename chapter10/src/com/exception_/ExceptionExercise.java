package com.exception_;

public class ExceptionExercise {
    public static void main(String[] args) {
        try {
            show();
            //主方法调用show()方法的时候，因为show()方法把异常抛出了，因此需要主方法处理该方法
            //主方法要么选择抛出，要么用try-catch方式来处理异常，出现异常地方后面的代码都不会被执行
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void show() throws Exception{
        //这里是自定义异常，throw是手动创建异常对象的关键字！！！
        //创建的异常也需要被处理
        throw new Exception(); //这是一个编译时异常，因此必须显示的处理
        //这里的Exception是所有编译异常和运行异常的父类，因此需要该方法显示处理该异常，采用throws或者try-catch
    }
}
