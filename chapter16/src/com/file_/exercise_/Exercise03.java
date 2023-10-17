package com.file_.exercise_;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//如何读取国标码形式的文件
//使用字符转换流来读取
public class Exercise03 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\a.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}
