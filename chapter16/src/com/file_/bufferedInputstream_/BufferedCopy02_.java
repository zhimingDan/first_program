package com.file_.bufferedInputstream_;


import java.io.*;

//使用字节处理流来完成文件的拷贝

//思考：字节流可以操作二进制文件，但是可以操作文本文件吗？
//当然可以，因为文本文件最终的处理方式还是会变成字节，但是字符流不能用来操作二进制文件，因为会出现书库丢失的现象
public class BufferedCopy02_ {
    public static void main(String[] args) {
        String srcFile = "E:\\MATLAB程序\\指纹库\\fingerprint.jpg";
        String destFile = "e:\\fingerprint.jpg";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //字节流读取的是字节，因此创建一个byte[]数组来接收读取的结果
        byte[] b = new byte[1024];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            int readLen = 0;
            while((readLen = bufferedInputStream.read(b)) != -1){ //如果返回-1，表示读到文件的末尾了
                bufferedOutputStream.write(b,0,readLen);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
