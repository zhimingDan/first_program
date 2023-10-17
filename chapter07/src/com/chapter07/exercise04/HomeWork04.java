package com.chapter07.exercise04;

public class HomeWork04 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(10000);
//        checkingAccount.deposit(100); //进行存钱操作
//        System.out.println(checkingAccount.getBalance());//输出存钱后的余额
//        checkingAccount.withDraw(1000);
//        System.out.println(checkingAccount.getBalance()); //输出取钱后的余额
        SavingsAccount savAcc = new SavingsAccount(100000);
        savAcc.setMonth(12);
        savAcc.earnMonthlyInterest(1.01);
        for (int i = 0; i < 5; i++) {
            savAcc.deposit(1000);
        }
        System.out.println(savAcc.getBalance());
    }
}
