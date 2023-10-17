package com.chapter07.exercise03;

/**
 * 需求：通过继承实现员工工资核算打印功能
 * 父类：员工类
 * 子类：部门经理类，普通员工类
 * 1.部门经理工资 = 1000 + 单日工资*天数*等级(1.2)
 * 2.普通员工的工资 = 单日工资*天数*等级(1.0)
 * 3.员工属性：姓名，单日工资，工作天数
 * 4.员工方法：(打印工资)
 * 5.普通员工和部门经理都是员工子类，需要重写打印工资的方法
 * 6.定义并初始化普通员工对象，调用打印工资的方法输出工资，定义并初始化部门经理对象，调用打印工资的方法输出工资
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Worker[] workers = new Worker[2];
        workers[0] = new Employer("jack",500,365,1.3);
        workers[1] = new Employee("jack",200,365,1.0);
        for (int i = 0; i < workers.length; i++) {
            workers[i].print();
        }
    }
}
