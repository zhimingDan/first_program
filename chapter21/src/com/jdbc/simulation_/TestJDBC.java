package com.jdbc.simulation_;

// 对JDBC进行测试
public class TestJDBC {
    public static void main(String[] args) {
        //从下面的案例中，可以看到接口的使用是非常的方便的，因为可以直接用父类的接口直接指向子类的接口
        JDBCInterface jdbc = new MysqlJDCB(); //使用多态，用父类引用指向子类对象
        jdbc.connect();
        jdbc.crud();
        jdbc.close();

        //此时如果需要调用oracle数据库只需要父类的引用指向其他的子类对象即可
        System.out.println("====================");
        jdbc = new OracleJDBC();
        jdbc.connect();
        jdbc.crud();
        jdbc.close();
    }
}
