package com.chapter07.houserentsystem;

import java.util.Scanner;

public class HouseRentApp {
    private String name;
    private String number;
    private String address;
    private double mouthPrice;
    private String condition;


    public HouseRentApp() {
    }

    public HouseRentApp(String name, String number, String address, double mouthPrice, String condition) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.mouthPrice = mouthPrice;
        this.condition = condition;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMouthPrice() {
        return mouthPrice;
    }

    public void setMouthPrice(double mouthPrice) {
        this.mouthPrice = mouthPrice;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void addHouse(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("姓名：");
        this.name = scanner.next();
        System.out.print("电话：");
        this.number = scanner.next();
        System.out.print("地址：");
        this.address = scanner.next();
        System.out.print("月租：");
        this.mouthPrice = scanner.nextDouble();
        System.out.print("状态(已出租/未出租)：");
        this.condition = scanner.next();
    }

    public String find(int index){
        return index + "\t" + name + "\t" +number +"\t"+ address + "\t" + mouthPrice + "\t" +condition;
    }

    public void alter(){ //传入一个引用
        Scanner myScanner = new Scanner(System.in);
        System.out.println("姓名"+"(" +name + "):");
        name = myScanner.next();
        System.out.println("电话"+"(" +number + "):");
        number = myScanner.next();
        System.out.println("地址"+"(" +address + "):");
        address = myScanner.next();
        System.out.println("租金"+"(" + mouthPrice + "):");
        mouthPrice = myScanner.nextDouble();
        System.out.println("状态"+"(" + condition + "):");
        condition = myScanner.next();
    }
}
