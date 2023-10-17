package com.exercise_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String fileName = "e:\\b.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "gbk");

        //如果此时不用处理流进行封装的话，那么就相当于一个节点流在读取数据
        char[] chars = new char[32];
        int readLine;
        while((readLine = isr.read(chars)) != -1){
            System.out.println(new String(chars,0,readLine));
        }

        isr.close();
    }
}
