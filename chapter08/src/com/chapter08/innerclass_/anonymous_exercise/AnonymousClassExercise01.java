package com.chapter08.innerclass_.anonymous_exercise;

/*
   匿名内部类的练习：
   1.有一个铃声接口Bell，里面有一个ring方法
   2.有一个手机类Phone，里面有闹钟功能alarmClock,参数是Bell类型
   3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印：懒猪起床了
   4.在传入另一个匿名内部类的对象内部，打印：小伙伴，开始上课了
   匿名内部类涉及的知识点(1)继承 (2)多态 (3)动态绑定机制 (4)内部类
 */
public class AnonymousClassExercise01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪，起床了");
            }
        });

        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们，开始上课了");
            }
        });
    }
}

interface Bell{
    public void ring();
}

class Phone{
    public void alarmClock(Bell bell){
        bell.ring(); //遵循动态绑定机制
    }
}
