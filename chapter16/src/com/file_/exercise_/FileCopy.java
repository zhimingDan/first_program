package com.file_.exercise_;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//管理员身份运行的原因：因为要对C盘进行操作，此时就要用管理员的身份来运行，不然无法操作
//完成文件拷贝操作
//步骤分析如下：
//1.从一个文件中读取数据
//2.在另外一个文件中输出读取的数据
public class FileCopy {
    public static void main(String[] args) {
        String fileName = "E:\\MATLAB程序\\指纹库\\fingerprint.jpg";
        String fileName2 = "e:\\fingerprint.jpg"; //这里不能写入一个目录，可以自己写一个文件名，系统会自己创建一个相应的文件的
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            fileOutputStream = new FileOutputStream(fileName2);
            byte[] b = new byte[1024];
            int readLength;

            while((readLength = fileInputStream.read(b)) != -1){

                fileOutputStream.write(b,0,readLength);
            }
            System.out.println("文件拷贝成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        }

    }
}
