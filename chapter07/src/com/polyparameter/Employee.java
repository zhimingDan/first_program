package com.polyparameter;

public class Employee {
    private String name;
    private double mouthSalary;

    public Employee(String name, double mouthSalary) {
        //构造器的目的就是对属性等进行用来初始化的
        this.name = name;
        this.mouthSalary = mouthSalary;
    }

    //set和get方法的目的就是对访问权限为private的属性来提供访问渠道的
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMouthSalary() {
        return mouthSalary;
    }

    public void setMouthSalary(double mouthSalary) {
        this.mouthSalary = mouthSalary;
    }

    public double getAnnual(){
        //心得：方法重写的作用到底是什么？为什么一定要进行方法重写？
        //根据本次代码中的总结：父类中的方法表示的是一般的情况，就拿本次代码来说，员工是
        //普通员工和经理的父类，普通员工和经理的计算年工资的方法大体上是相同的，都是月工资乘以12个月
        //那么我就可以考虑把计算(月工资乘以12个月)这个公共的部分分离出来，在父类中体现。但是两者计算年工资又有不同
        //我可以在子类中重写这个方法，在子类中调用父类的方法，然后在和子类中的特殊情况合起来，这样就构成了子类的方法
        //我觉得这就是重写的意义
        //重写不是必须的，但是重写可以使代码更加简洁，复用性更强，因为这是子类共有的特点，将来我再次创建一个新的子类的时候
        //我就可以直接来调用父类的方法，这样可以减少代码的工作量，因此在写继承关系的时候，应该多想想子类与子类之间的共同点
        return mouthSalary * 12;
    }
    public void introduce(){
        System.out.println("name:" + name + "\t mouthSalary:" + mouthSalary);
    }
}
