package com.jdbc.demo01;


import com.mysql.jdbc.Driver;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

//演示数据库的使用
public class Jdbc01 {
    public static void main(String[] args) throws Exception {
        //前置工作：首先需要引入mysql对应的jar包，因此需要在项目下创建一个目录，然后将mysql.jar复制到该目录下
        //然后点击"添加库(add library)",将jar包加入到项目中

        //1.注册驱动 -> 注册驱动的时候，类名是com.mysql.jdbc.driver !!! 而不是直接创建driver对象
        Driver driver = new Driver();

        //2.得到连接
        //老师说明：
        //1). jdbc:mysql:// -> 是规定好的写法，是一个协议，表示用jdbc连接到mysql这个数据库
        //2). localhost -> 表示主机，也可以是写ip地址
        //3). 3306 -> 表示数据库管理系统监听的端口
        //4). db01 -> 表示要连接到数据库管理系统中的那个数据库
        //5). 实际上mysql的连接的底层本质上还是一个socket的连接
        String url = "jdbc:mysql://localhost:3306/db01";

        //想要连接到数据库，是需要账号和密码的，因此需要将mysql的账号和密码写入到Properties对象中
        Properties properties = new Properties();
        //说明：其中的user 和 password 都是不能更改的，但是后面的值需要根据具体账号和密码进行存储
        properties.setProperty("user","root");
        properties.setProperty("password","szm");

        //开始进行数据库的连接，调用Driver对象中的connect方法进行连接
        Connection connect = driver.connect(url, properties);


        //3.执行sql语句
        //(1) 先创建一个Statement对象，用于执行静态SQL语句，并返回其生成的结果对象
        Statement statement = connect.createStatement();
        //(2) 写好想要执行的sql语句，例如添加一条记录
        String sql = "insert into actor values(null,'jack','男','1970-11-11','123456789120')";

        //(3) 开始执行sql语句
        //解读：executeUpdate表示执行sql语句，返回值row表示影响的行数
        int row = statement.executeUpdate(sql);
        //如果影响的行数大于0，则表示执行成功，如果等于0，则表示执行失败
        System.out.println(row > 0 ? "执行成功":"执行失败");

        //4.关闭连接
        statement.close();
        connect.close();
    }

    // 方式5：使用配置文件来进行连接
    public void connect() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileReader("E:\\IDEA项目\\first_program\\chapter21\\src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("方式5：" + connection);
    }
}
