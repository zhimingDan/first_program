package com.chapter09.enum_exercise01;

//枚举的好处是什么：通过使用枚举可以固定用户使用对象的范围

//这里先使用外部类的枚举

//public class EnumTest {
//    public static void sel(Train train){//传入枚举对象
//        switch(train){
//            case TRAIN_NUMBER_07:
//                System.out.println("用户乘坐的是7号线公交车回家...");
//                break;
//            case TRAIN_NUMBER_14:
//                System.out.println("用户乘坐的是14号线公交车回家...");
//                break;
//            case TRAIN_NUMBER_28:
//                System.out.println("用户乘坐的是28号线公交车回家...");
//                break;
//            default:
//                System.out.println("用户选择了走路回家...");
//        }
//    }
//
//    public static void main(String[] args) {
//        for(Train train : Train.values()) { //采用增强for循环
//            sel(train);
//        }
//        try {
//            sel(null);
//        } catch (Exception e) {
//            System.out.println("异常信息为：" + e.getMessage());
//        }
//    }
//}
//
//enum Train{//一个枚举类
//    //定义三个枚举类的实例
//    TRAIN_NUMBER_14,TRAIN_NUMBER_28,TRAIN_NUMBER_07;
//}


//以上代码均是采用的外部枚举的方法，下面来创建内部枚举

public class EnumTest{
    enum Train{
        TRAIN_NUMBER_14,TRAIN_NUMBER_28,TRAIN_NUMBER_07;
    }

    public static void main(String[] args) {
        Work work = new Work();
       // work.sel(TRAIN_NUMBER_14); //相当于外部类访问内部类的静态成员，需要通过类名.成员来访问
        work.sel(Train.TRAIN_NUMBER_07);
    }
}

class Work{
    public void sel(EnumTest.Train train){
        switch(train){
            case TRAIN_NUMBER_07:
                System.out.println("用户乘坐的是7号线公交车回家...");
                break;
            case TRAIN_NUMBER_14:
                System.out.println("用户乘坐的是14号线公交车回家...");
                break;
            case TRAIN_NUMBER_28:
                System.out.println("用户乘坐的是28号线公交车回家...");
                break;
            default:
                System.out.println("用户选择了走路回家...");
        }
    }
}
