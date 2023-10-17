package com.chapter07.exercise05;

public class Test {
    public static void main(String[] args) {
        Doctor[] doctors = new Doctor[2];
        doctors[0] = new Doctor("jack",20,"work",'男',20000);
        doctors[1] = new Doctor("jack",18,"work",'男',20000);
        if(doctors[0].equals(doctors[1])){
            System.out.println("两者相等");
        }else{
            System.out.println("两者不相等");
        }
    }
}
