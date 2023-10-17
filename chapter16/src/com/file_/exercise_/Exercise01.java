package com.file_.exercise_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//编程题，要求如下：
//1.判断e盘下是否有文件夹myTemp,如果没有就创建一个
//2.在e:\myTemp目录下创建一个文件hello.txt
//3.如果文件已存在，则提示该文件已存在，反之则创建该文件
public class Exercise01 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\myTemp";
        File file = new File(filePath);

        if(!file.exists()){
            file.mkdir();
        }

        //如果是父类路径的话，是不用加\\的
        File file1 = new File(file,"hello.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("文件创建成功");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
            bufferedWriter.write("hello,world");

            //必须要关闭流，否则会写不进去
            bufferedWriter.close();
        }else{
            System.out.println("文件已存在");
        }

    }
}
