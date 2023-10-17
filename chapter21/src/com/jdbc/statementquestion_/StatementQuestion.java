package com.jdbc.statementquestion_;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

// 演示sql注入问题
@SuppressWarnings({"all"})
public class StatementQuestion {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //一定要注意：这里不能使用next来接收字符串，因为如果输入的数据中包含空格,next就会认为时结束的标志
        //因此，需要使用nextLine，nextLine的结束标志时输入回车
        //可以发现，如果用户名输入： 1' or
        //          密码输入：or '1' = '1 ->此时也是会登录成功的
        //          因此这就是sql注入的问题之一，sql注入还会破坏数据库中的数据，所以危害很大
        System.out.print("请输入用户名: ");
        String name = scanner.nextLine();
        System.out.print("请输入密码: ");
        String psw = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileReader("E:\\IDEA项目\\first_program\\chapter21\\src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //1.注册驱动
        Class.forName(driver);

        //2.建立连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3.得到statement
        Statement statement = connection.createStatement();

        //4.组织sql语句
        //注意：使用where语句进行条件过滤时，如果使用的时变量来进行条件过滤，那么单引号一定不能忘记
        String sql = "select * from admin where name = '" + name + "' and psw = '" + psw + "'";

        //执行指定的sql语句，返回单个ResultSet对象
        // -> 一定要注意：select 语句不是dml语句，因此使用执行sql语句的方法也不一样
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("登录成功!");
        }else {
            System.out.println("登录失败!");
        }
    }
}
