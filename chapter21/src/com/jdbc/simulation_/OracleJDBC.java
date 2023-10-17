package com.jdbc.simulation_;

public class OracleJDBC implements JDBCInterface{

    @Override
    public Object connect() {
        System.out.println("连接到oracle数据库");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("对oracle数据库进行增删改查的操作");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle数据库的连接");
    }
}
