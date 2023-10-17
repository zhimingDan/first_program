package com.jdbc.utils_;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//创建一个JDBCUtils的工具类
public class JDBCUtils_ {
    //因为是从properties中来获取属性，而且每个属性只需要一份
    private static String user; // 用户名
    private static String password; // 密码
    private static String url; //url
    private static String driver; //driver

    //在静态代码块中来完成变量的初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，通常都是将捕获的编译异常转化为运行异常
            //此时，调用者可以根据自己的实际情况，选择捕获该异常，也可以选择默认处理该异常
            throw new RuntimeException(e);
        }
    }

    //编写连接资源的程序
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            //在实际开发中，通常都是将捕获的编译异常转化为运行异常
            //此时，调用者可以根据自己的实际情况，选择捕获该异常，也可以选择默认处理该异常
            throw new RuntimeException(e);
        }
    }

    //编写关闭资源的程序：
    //因为实际中需要关闭的资源有可能为：
    //1.ResultSet 结果集  2.Statement 或者PreparedStatement  3.Connection
    //因此可以使用方法的重载
    //这里为什么使用Statement接口就可以了，因为Statement接口是PreparedStatement的父接口，因此可以根据多态以及
    //动态绑定机制来完成对PreparedStatement实现对象的关闭
    public static void close(Statement statement,Connection connection){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
