package com.encapsulation;

public class EncapExercise {
    public static void main(String[] args) {
        Account jack = new Account("jack", 1900.8, "123456");
        System.out.println(jack.info());

    }
}

class Account {
    //为了封装，将三个属性设置为private类型
    private String name;
    private double balance;
    private String keyword;

    public Account(String name, double balance, String keyword) {
        setName(name);
        setBalance(balance);
        setKeyword(keyword);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("您输入的姓名的格式有误，将给您设置为默认姓名");
            this.name = "无名氏";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("输入的余额必须大于20");
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        if (keyword.length() == 6) {
            this.keyword = keyword;
        } else {
            System.out.println("密码的长度只能是6位，将给您设置默认密码");
            this.keyword = "111111";
        }
    }

    public String info() {
        return "name :" + name + " balance :" + balance + " keyword :" + keyword;
    }
}
