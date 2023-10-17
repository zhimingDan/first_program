package com.file_.bufferedreader_;

import java.io.*;

//使用字符处理流完成文件的拷贝
public class BufferedCopy01_ {
    public static void main(String[] args) {
        String srcFile = "E:\\IDEA项目\\first_program\\chapter16\\src\\com\\file_\\createfile_\\CreatFile.java";
        String destFile = "e:\\a.java";
        String line;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));

            //读取文件中一行的内容，如果读取到文件末尾则返回一个null
            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line); //将读取的内容写入到指定文件中，如果没有文件，则先创建一个文件
                bufferedWriter.newLine(); //换行 ，写入的字符并不会自动换行
            }

            System.out.println("文件拷贝完毕");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //关闭流
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
