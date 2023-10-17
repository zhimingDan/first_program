package com.chapter08.interface_;

//抽象类对于接口确实有屏蔽的作用


public class DbMysql implements DbInterface{

    @Override
    public void connect() {
        System.out.println("数据库连接成功");
    }

    @Override
    public void close() {
        System.out.println("数据库已断开连接");
    }
}



