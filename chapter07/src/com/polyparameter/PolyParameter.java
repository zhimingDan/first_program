package com.polyparameter;

/*
项目要求：
  定义一个员工类Employee，包含名字和工资(private),以及计算年工资getAnnual的方法，普通员工和经理继承了员工
  经理类多了奖金bonus属性和管理方法manage，普通员工类多了work方法，普通员工和经理类分别要求重写getAnnual方法

  定义一个测试类Test，测试类中添加一个方法showEmpAnnual(Employee e),实现获取任何员工对象的年工资，并在mian方法中调用该方法

  测试类中添加一个方法TestWork，如果是普通员工，则调用work方法，如果是经理，则调用manage方法
*/

public class PolyParameter {
    public static void main(String[] args) {
        Test test1 = new Test();
        test1.test();
    }
}
