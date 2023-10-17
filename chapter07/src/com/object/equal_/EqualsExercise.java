package com.object.equal_;
//判断两个Person对象的内容是否相等，如果两个Person对象的属性值都是相等的，那么就返回true，反之，返回false
public class EqualsExercise {
    public static void main(String[] args) {
        Person person1 = new Person("jack",20,'男');
        Person person2 = new Person("jack",20,'男');
        //System.out.println(person1.equals(person2)); //此时没有重写equals方法的时候，此时
        //equals方法是继承Object中的equals方法，而Object中的方法是比较两个对象的地址是否相等。因此此时结果是false
        System.out.println(person1.equals(person2));
    }

}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    //重写equals方法
    public boolean equals(Object obj){
        //如果判断比较的两个对象是同一个对象，那么直接返回ture
        if(this == obj){  //this表示当前对象
            return true;
        }
        if (obj instanceof Person) {//如果传进来的是Person类的对象，我才可以进行比较
            Person person = (Person)obj; //此时进行向下转型，因为此时调用的是Person类中特有的属性
            // return this.name == person.name && this.age == person.age && this.gender == person.gender;
            //这里的equals两端是引用数据类型，因此使用equals是调用的String类中的equals方法
            return this.name.equals(person.name) && this.age == person.age && this.gender == person.gender;
        }
        return false;
    }
}