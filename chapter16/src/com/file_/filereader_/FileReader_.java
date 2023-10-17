package com.file_.filereader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    //采用字符的方式读取文件的内容，读取操作是在读取完一行要读取下一行的时候，是会能够自动换行的，不同人为的去换行
    public void method1(){
        String fileName = "E:\\IDEA项目\\first_program\\chapter16\\src\\com\\file_\\createfile_\\CreatFile.java";
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);

            int readLen = 0;
            char[] ch = new char[8];

            while((readLen = fileReader.read(ch)) != -1){
                System.out.print(new String(ch,0,readLen)); //可以直接依靠被读取文件的内部的自己的换行
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


