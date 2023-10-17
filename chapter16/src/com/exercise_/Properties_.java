package com.exercise_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//读取配置文件中的方法
public class Properties_ {
    public static void main(String[] args) throws IOException {
        //方法一：使用读取文件的方式来读取配置文件中的键值对
        String fileName = "e:\\IDEA项目\\first_program\\chapter16\\src\\mysql.properties";

        //使用处理流来进行数据的读取
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String readLine = "";
        while((readLine = br.readLine()) != null){//读取一行的数据到readLine中，因为键值对都是使用"="分开的
            String[] split = readLine.split("=");
            System.out.println(split[0] + " = " + split[1]);
        }
        //完成操作之后，关闭相应的流
        br.close();

        System.out.println("====================================");
        //方法二：使用Properties集合类来读取配置文件中的数据

        Properties properties = new Properties();//创建一个集合类对象
        properties.load(new FileReader(fileName)); //将配置文件中的键值对加载到properties对象中

        //通过键来寻找值
        String str = properties.getProperty("ip");
        System.out.println("对应的值是：" + str);


        //将集合类Properties中的数据全部写入到配置文件中
        Properties properties1 = new Properties();
        properties1.setProperty("name","jack");
        properties1.setProperty("age","20");
        properties1.store(new FileWriter("e:\\IDEA项目\\first_program\\chapter16\\src\\mysql02.properties"),null);

    }
}
