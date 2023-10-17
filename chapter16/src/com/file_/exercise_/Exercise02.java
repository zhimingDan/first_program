package com.file_.exercise_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//要求：使用BufferedReader读取一个文本文件，为每行加上一个行号，并连同内容一起输出到屏幕上
public class Exercise02 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\a.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;
        int count = 1;
        while((line = bufferedReader.readLine()) != null){
            System.out.print(count + ". ");
            System.out.println(line);
            count++;
        }

        bufferedReader.close();
    }
}
