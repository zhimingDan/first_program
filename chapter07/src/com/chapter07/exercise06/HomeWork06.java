package com.chapter07.exercise06;

public class HomeWork06 {
    public static void main(String[] args) {
        Person[] persons = new Person[4];  //定义一个多态数组来存子类的对象
        persons[0] = new Teacher("jack",'男',35,"10");
        persons[1] = new Teacher("jack",'男',62,"44");
        persons[2] = new Student("jack",'男',13,"19040302");
        persons[3] = new Student("jack",'男',9,"19040303");
        Person temp = null;
        for (int i = 0; i < persons.length -1; i++) {
            for (int j = 0; j < persons.length - 1 -i ; j++) {
                if(persons[j].getAge() < persons[j+1].getAge()) {//如果后面的年龄比前面小，那么就进行交换
                    temp = persons[j]; //对于值的交换，是看的编译类型而不是运行类型
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
            if(persons[i] instanceof Teacher){
                //persons[i].teach();  这一行代码是错误的，因为teach是子类特有的方法，需要向下转型
                Teacher teacher = (Teacher)persons[i];
                teacher.teach();
                System.out.println(teacher.play());
            }else{
                //persons[i].teach();  这一行代码是错误的，因为teach是子类特有的方法，需要向下转型
                Student student = (Student)persons[i];
                student.study();
                System.out.println(student.play());
            }
            System.out.println("------------------------------");
        }
    }
}
