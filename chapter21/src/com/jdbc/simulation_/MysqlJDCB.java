package com.jdbc.simulation_;

public class MysqlJDCB implements JDBCInterface{ //实现数据库的接口的方法
    @Override
    public Object connect() {
        System.out.println("连接到mysql数据库");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("对mysql数据库进行增删改查的操作");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql数据库的连接");
    }
}
