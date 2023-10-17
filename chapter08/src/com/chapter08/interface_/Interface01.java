package com.chapter08.interface_;


//感觉接口就是实现抽象类的继承加上多态参数的功能，因为类的继承最好是要满足Xxx 是 Xxx 的逻辑，而接口可以不用
public class Interface01 {
    public static void main(String[] args) {
        //DbInterface dbInterface1 = new DbInterface();  //接口和抽象类类似，也无法实例化
        DbMysql dbMysql = new DbMysql();
        work(dbMysql);

    }
    public static void work(DbInterface dbInterface){
        dbInterface.connect();
        dbInterface.close();
    }
}
