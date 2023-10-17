package com.polyparameter;

public class Test {
    public  void test() {
        Employee[] person = new Employee[4];
        person[0] = new ComEmployee("jack",6000);
        person[1] = new ComEmployee("marry",5000);
        person[2] = new Employer("mark",15000,90000);
        person[3] = new Employer("jerry",30000,100000);
        for (int i = 0; i < person.length; i++) {
            person[i].introduce();
            TestWork(person[i]);
        }

    }
    public double showEmpAnnual(Employee e){
        //为什么这里要使用多态？
        //因为我发现这个方法是我要访问子类的某个属性或者方法的时候，我肯定要传入子类的引用
        //这样才可以在这个方法中去访问子类的属性和方法，但是我发现这个方法多个子类都要调用
        //难道我要写一个方法重载吗？(改变形参的类型为每个子类的类型)
        //我发现有些复杂，可以用多态的方式来解决(个人感觉多态就是个小型的创建对象，因为他可以调用你创建的对象中和父类所有相同的成员
        // 但就是不能调用你创建的对象的特有的成员),所以向上转型的目的就是为了调用重写的方法，因为重写的方法体现了子类的特殊性
        return e.getAnnual();//动态绑定机制
    }
    public void TestWork(Employee e){
        //和上面同理
        if(e instanceof ComEmployee){ //如果传入的对象是普通员工，则调用普通员工的work();
            ((ComEmployee)e).work();//为什么要使用向下转型？我需要调用我自己特有的方法，此时向上转型已经不能够实现了
        }else if(e instanceof Employer){//如果传入的对象是经理，则调用经理的manage();
            ((Employer)e).manage();
        }
        System.out.println(showEmpAnnual(e));
    }
}
