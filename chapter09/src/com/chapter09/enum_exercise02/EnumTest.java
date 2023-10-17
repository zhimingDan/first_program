package com.chapter09.enum_exercise02;


//实现带有抽象方法的enum类
//枚举类型适用于我想要输出的东西的选择是固定的，而且输出东西的属性很多，不止一个
public class EnumTest {
    enum TrafficLamp{
        RED{
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        },GREEN{
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },YELLOW{
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        };
        public abstract TrafficLamp nextLamp();
    }

    public static void printTrain(TrafficLamp trafficLamp){
        switch(trafficLamp){
            case GREEN :
                System.out.println(TrafficLamp.GREEN);
                break;
            case RED:
                System.out.println(TrafficLamp.RED);
                break;
            case YELLOW:
                System.out.println(TrafficLamp.YELLOW);
                break;
            default:
                System.out.println("输入有误");
        }
    }
    public static void main(String[] args) {
        printTrain(TrafficLamp.GREEN.nextLamp());
    }
}
