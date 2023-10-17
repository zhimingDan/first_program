package com.chapter08.homework.third_;

/*   编程题：
     1.计算器接口有个Work方法，功能是运算，有一个手机类，定义TestWork方法，测试计算功能，调用计算机接口Work方法
     2.要求调用CellPhone对象的TestWork方法，使用上匿名内部类
 */
public class HomeWork {
    public static void main(String[] args) {
//        Computer computer = new Computer(){
//            @Override
//            public double work(double n1, double n2) {
//                return n1 + n2;
//            }
//        };
//
//        CellPhone cellPhone = new CellPhone();
//        cellPhone.testWork(computer,10,20);

        //将上面的步骤合并可得
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,20);
    }
}

interface Computer{
    public double work(double n1,double n2);
}

class CellPhone{ //接口的调用者
    public void testWork(Computer computer , double n1, double n2){
        System.out.println(computer.work(n1,n2));
    }

}


