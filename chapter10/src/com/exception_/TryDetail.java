package com.exception_;

//可以使用多个catch语句捕获不同的异常，但是要求子类异常在前,父类异常在后

public class TryDetail {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName()); //这里会报NullPointerException,一旦这里出现异常，下面的代码是不会执行的
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//这里会出现ArithmeticException
            System.out.println("结果为：" + res);
            //我可以对不同的异常，进行不同的处理
        } catch(NullPointerException e){
            System.out.println("空指针异常：" + e.getMessage());
        } catch(ArithmeticException e){
            System.out.println("算数异常：" + e.getMessage());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

class Person{
    private String name = "jack";

    public String getName() {
        return name;
    }
}
