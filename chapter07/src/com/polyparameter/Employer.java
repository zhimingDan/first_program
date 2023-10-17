package com.polyparameter;

public class Employer extends Employee{
    private double bonus;

    public Employer(String name, double mouthSalary, double bonus) {
        super(name, mouthSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getAnnual(){
        //方法重写：因为经理的工资有其本生的特殊性，但是其共性还是要发掘出来，将共性和个性组合就是
        //这个类的特点了
        return getMouthSalary() * 12 + bonus; //经理的年工资等于月工资乘以12 + 年终奖
    }
    public void manage(){
        System.out.println(super.getName() + " 经理正在管理");
    }
}
