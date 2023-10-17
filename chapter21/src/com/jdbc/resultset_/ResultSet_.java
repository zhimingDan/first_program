package com.jdbc.resultset_;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

//演示select语句，返回的结果用结果集ResultSet来进行接收
@SuppressWarnings({"all"})
public class ResultSet_ {
    public static void main(String[] args) throws Exception {
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
        String sql = "select id,name,sex,borndate from actor";

        //执行指定的sql语句，返回单个ResultSet对象
        // -> 一定要注意：select 语句不是dml语句，因此使用执行sql语句的方法也不一样
        ResultSet resultSet = statement.executeQuery(sql);

//                +----+--------+-----+---------------------+--------------+
//                | id | name   | sex | borndate            | phone        |
//                +----+--------+-----+---------------------+--------------+
//                |  1 | jack   | 男  | 1970-11-11 00:00:00 | 123456789120 |
//                |  2 | 刘德华 | 男  | 1969-12-12 00:00:00 | 12345        |
//                +----+--------+-----+---------------------+--------------+

        //5.使用while循环取出数据
        while(resultSet.next()){ //让光标向后移，如果没有更多行了，则返回一个false
            //首先，这个光标指向表头，也就是第一行记录的前面
            int id = resultSet.getInt(1); //获取该表的第一列数据
            //这个getXxx方式是一个重载的方法，也可以通过传入列名来得到数据
            int id1 = resultSet.getInt("id");//推荐使用，因为可以不用管列的访问顺序
            String name = resultSet.getString(2); //获取该表的第二列数据
            String sex = resultSet.getString(3);//获取该表的第三列数据
            Date date = resultSet.getDate(4); //获取该表的第四列数据
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        //6.关闭连接,必须要关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
