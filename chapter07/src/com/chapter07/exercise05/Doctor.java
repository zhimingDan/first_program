package com.chapter07.exercise05;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    public boolean equals(Object obj){//一定要好好理解重写代码的意义，因为这就是一个方法，所以比较的类肯定是可以直接调用的
        if(this == obj){
            return true;
        }
        if(obj instanceof Doctor){
            Doctor doc = (Doctor)obj; //调用子类中特有的属性的时候，一定要向下转型
            if(this.age == (doc.getAge()) && this.gender == (doc.getGender()) && this.name.equals(doc.getName())&&
            this.job.equals(doc.getJob())&&this.sal == (doc.getSal())){
                return true;
            }
        }
        return false;
    }
}
