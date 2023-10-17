package com.file_.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//使用Properties集合来读取配置文件中的内容
public class Properties02_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //1.首先先将配置文件加载到Properties集合中,这里采用的读取的方式是字符流的方式读取
        properties.load(new FileReader("e:\\IDEA项目\\first_program\\chapter16\\src\\mysql.properties"));

        //2.将数据显示到指定的显示设备，以下采用标准输出，这里就是一个输出
        properties.list(System.out);

        //3.可以根据指定的键来获取值
        String str = properties.getProperty("user"); //会返回一个String类型的值
        System.out.println("用户名是：" + str);

    }
}
