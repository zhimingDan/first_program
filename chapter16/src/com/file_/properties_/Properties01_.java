package com.file_.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//使用普通方法去读取配置文件
public class Properties01_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("e:\\IDEA项目\\first_program\\chapter16\\src\\mysql.properties"));
        String line = "";

        //因为保存的数据都是String类型的，而且中间会有等于号，因此可以直接使用split()方法进行切割
        while((line = br.readLine()) != null){
            //如果想要只得到值，那么就可以使用split()方法按照 = 号来进行分割
            String[] split = line.split("=");
            System.out.println(split[0] + "值是： " + split[1]);
        }
        br.close();
        System.out.println("读取完成");
    }
}
