package com.chapter08.abstract_;

//抽象类的练习

public class AbstractExercise {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", "1234", 10000, 1000);
        CommonEmployee tom = new CommonEmployee("tom", "2345", 6000);
        jack.work();
        tom.work();
    }

}

abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //不同的子类，工作的方式不一样，因此定义成一个抽象方法来当做模板
    public abstract void work();
}

class Manager extends Employee{//子类继承了父类，那么子类就有父类所有的属性以及必须重写父类的抽象的方法
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
    public void work(){
        System.out.println("经理" + this.getName() + "正在工作");
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work(){
        System.out.println("员工" + this.getName() + "正在工作");
    }
}
