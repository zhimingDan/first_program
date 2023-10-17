package com.chapter12.map_;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*  要求如下：使用HashMap添加三个员工对象。要求:
    键：员工id
    值：员工对象

    遍历并显示工资 > 18000的员工(遍历方式至少两种)
    员工类包含：员工id,员工姓名，员工工资

 */
public class MapExercise_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("123456",new Employee("123456","jack",19999));
        map.put("456789",new Employee("456789","rose",17890));
        map.put("101010",new Employee("101010","tom",20000));

        Set set = map.entrySet(); // 得到键值对
        for (Object o : set) { //使用增强for来进行遍历
            Map.Entry entry = (Map.Entry) o; //进行向下转型，使之能够访问K - V
            Employee e = (Employee) entry.getValue(); //得到的getValue的类型是Object类型，因此需要进行向下转型
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }

        System.out.println("==============使用迭代器=============");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry entry = (Map.Entry) next;
            Employee employee = (Employee) entry.getValue();
            if(employee.getSal() > 18000){
                System.out.println(employee);
            }
        }
    }
}

class Employee{
    private String id;
    private String name;
    private double sal;

    public Employee(String id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
