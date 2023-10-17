package com.file_.properties_;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//使用Properties来创建配置文件，修改配置文件的内容
public class Properties03_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        //下面的这些操作都是保存在Properties的集合中
        /*
            实际上把一个数据写入到集合中还可以使用双列集合的写入方法put()来写入键值对
            但是为什么不使用呢？
            因为put方法写入的是一个对象，如果是String类型是可以和配置文件兼容的，但是如果是其他的类型就不可以了
            而setProperty则是直接写入一个String类型的变量
         */
        properties.setProperty("charSet","utf-8");
        properties.setProperty("user","汤姆"); //配置文件中中文保存的是unicode码值
        properties.setProperty("psw","88888");

        //后面的null表示备注，如果写的话，则会在.properties文件的第一行中显示出来
        //一定要注意：Properties是Hashtable的子类，底层的排序是按照哈希值排序的，所以，并不是我们想象的顺序排列的

        //只有调用store函数的时候，才会成功将键值对写入到配置文件中。
        properties.store(new FileWriter("e:\\IDEA项目\\first_program\\chapter16\\src\\mysql01.properties"),null);

        System.out.println("文件配置成功");
    }
}
