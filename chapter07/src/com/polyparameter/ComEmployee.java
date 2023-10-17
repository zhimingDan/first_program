package com.polyparameter;

public class ComEmployee extends Employee{

    public ComEmployee(String name, double mouthSalary) {//构造函数
        super(name, mouthSalary);
    }
    public void work(){
        System.out.println(getName() + "员工正在工作");
    }
    public double getAnnual(){ //重写父类中的计算年工资的方法
        return getMouthSalary() * 12;
    }
}
