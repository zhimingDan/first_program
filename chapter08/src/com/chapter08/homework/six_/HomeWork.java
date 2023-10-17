package com.chapter08.homework.six_;

/*   编程题：内部类的编程题
     有一个Car类，有属性temperature(温度)，车内有Air(空调)类，有吹风的工能flow，Air会监视车内的温度
     如果温度超过40度则吹冷气，如果温度低于0度则吹暖气，如果在这个之前则会关闭空调，实例化具有不同温度
     的Car对象，调用空调的flow方法，测试空调吹的风是否正确
 */
public class HomeWork {
    public static void main(String[] args) {
        Car car1 = new Car(40);
        Car car2 = new Car(28);
        Car car3 = new Car(-1);
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
        new Air().flow();
    }

    class Air{
        public void flow(){
            if( temperature >= 40){
                System.out.println("车内温度过热，空调开始工作，开始吹冷风....");
            } else if (temperature >= 0) {
                System.out.println("车内温度正常，空调停止工作.....");
            }else{
                System.out.println("车内温度过冷，空调开始工作，开始吹暖气....");
            }
        }
    }
}
