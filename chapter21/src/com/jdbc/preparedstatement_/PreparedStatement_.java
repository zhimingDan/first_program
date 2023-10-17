package com.jdbc.preparedstatement_;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//演示PreparedStatement 的使用
@SuppressWarnings({"all"})
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception{
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

        //3. 得到PreparedStatement
        //3.1 组织sql,sql语句中的?相当于占位符
        String sql = "select * from admin where name = ? and psw = ?"; //使用?来进行占位

        //3.2 preparedStatement对象实现了Preparedment接口的实现类对象
        //这里必须要传入sql语句，传入sql语句后就相当于preparedStatement和该sql语句进行了绑定
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //3.3 给sql语句中的问号进行赋值操作
        //这里中的int类型的数据表示sql语句中的第几个问号
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,psw);



        //4.执行指定的sql语句，返回单个ResultSet对象
        //如果执行的时select(查询)语句，此时就使用executeQuery()
        //如果执行的时dml(增，删，修改)语句，此时就使用executeUpdate()语句
        //-> 一定要注意：select 语句不是dml语句，因此使用执行sql语句的方法也不一样

        //注意：此时执行语句中不用写入sql语句，因为前面创建PreparedStatement对象的时候，就进行了sql语句的绑定
        //不论时executeQuery()还是executeUpdate()里面都不能加sql语句
        ResultSet resultSet = preparedStatement.executeQuery();

        //ResultSet resultSet = preparedStatement.executeQuery(sql);
        //如果在executeQuery()中填入了sql语句，此时就相当于直接运行填入的sql语句，而不会将sql语句中的?号进行代替
        if(resultSet.next()){
            System.out.println("登录成功!");
        }else {
            System.out.println("登录失败!");
        }

        //关闭连接：
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
