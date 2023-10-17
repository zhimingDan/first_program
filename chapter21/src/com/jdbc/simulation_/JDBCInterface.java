package com.jdbc.simulation_;

public interface JDBCInterface { // 模拟JDBC
    public Object connect(); // 用于模拟数据库的连接
    public void crud(); //模拟数据库的增删改查方法
    public void close(); //模拟关闭数据库的连接
}
