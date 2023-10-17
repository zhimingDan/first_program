package com.chapter07.exercise04;

public class BankAccount {
    private double balance; //余额
    public BankAccount(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){//存款方法
        balance += amount;
    }
    public void withDraw(double amount){ //取款方法
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

/**
 * 要求如下：
 * 1.在上面类的基础上扩展新类CheckingAccount，对每次存款和取款都收取一美元的手续费
 * 2.扩展前一个练习的BankAccount类，新类SavingsAccount每个月都有利息产生(earnMonthlyInterest方法类调用)
 * 并有每个月三次免手续费的存款或者取款，并且在该方法中重叠交易计数
 */

class CheckingAccount extends BankAccount{
    public CheckingAccount(double balance) {
        super(balance);
    }
    public void deposit(double amount){//存款方法
        super.deposit(amount);
        setBalance(getBalance()-1);  //一定要注意这种写法
    }
    public void withDraw(double amount){ //取款方法
        super.withDraw(amount);
        setBalance(getBalance()-1);
    }
}

class SavingsAccount extends CheckingAccount{
    private int month;  //用来设置存钱的月份
    private int count = 0; //用来计算交易的次数
    public SavingsAccount(double balance) {
        super(balance);
    }
    public void earnMonthlyInterest(double profit){  //用来计算利息
        super.setBalance(super.getBalance()* profit * this.month); //计算存储几个月后的利息
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void deposit(double amount){//存款方法
        if(count <= 3){
            super.deposit(amount); //交易次数小于3，不用手手续费
            count++;
            return;
        }
        super.deposit(amount);
        setBalance(getBalance()-1);  //一定要注意这种写法
    }
    public void withDraw(double amount){ //取款方法
        if(count <= 3){
            super.withDraw(amount); //交易次数小于3，不用手手续费
            count++;
            return;
        }
        super.withDraw(amount);
        setBalance(getBalance()-1);
    }
}