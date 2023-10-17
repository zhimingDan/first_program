package com.file_.exercise_.exercise001;

import java.io.FileInputStream;
import java.io.IOException;

//对字节流输入的练习
public class FileInputStreamExercise {
    public static void main(String[] args) {
        //从某个文件中读取字符，分别使用两种不同的方式来进行读取
        String filePath = "e:\\myRecord.txt"; //指定文件的读取路径
        FileInputStream fis = null; //字节流读取数据

        try {
            fis = new FileInputStream(filePath);//创建了一个流对象，就相当于建立了程序与文件的连接
//            int readKey;
//            while((readKey = fis.read()) != -1){ //如果有读取的值不是-1，代表没有到达文件末尾
//                System.out.print((char)readKey);
//            }

            //方式二：
            byte[] b = new byte[8];
            int readLen;
            while((readLen = fis.read(b)) != -1){
                System.out.print(new String(b,0,readLen));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(fis != null){ //关闭流的操作
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
