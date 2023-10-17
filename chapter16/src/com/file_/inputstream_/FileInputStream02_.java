package com.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;


//演示使用read(byte[] b)来读取文件内容
public class FileInputStream02_ {
    public static void main(String[] args) {

    }

    /**
     * 注意：虽然read(byte[] b) 方法每次读取b.length个字节
     * 但是实际上是一个字节一个字节的方式读取的，然后当读取到第b.length个字节后，然后返回
     */
    @Test
    public void method2(){
        FileInputStream fileInputStream = null;
        String fileName = "e:\\hello.txt";
        byte[] b = new byte[8];
        int readLength;
        try {
            fileInputStream = new FileInputStream(fileName);


            //对如下代码的解析
            //fileInputStream.read(b)表示每次从文件中读取b.length个字节，因此比read()每次只读取一个字节，效率大大提升
            //返回值是每次从问文件中读取的字节数，如果读取到文件末尾，那么返回值就是-1
            //1.如果文件中的字节数 > b.length ,那么每次返回的就是 b.length
            //2.如果文件中的字节数 < b.length ,那么每次返回就是剩余的字节数
            //3.当文件中的字节都被读取完后，就会返回 -1;
            while((readLength =fileInputStream.read(b)) != -1){
                //利用String类型的构造器来进行返回
                //但是一定要注意，每次读取满后返回，下次读取会从下标为0开始进行覆盖
                System.out.print(new String(b,0,readLength));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally { //操作完成文件后一定要及时关闭对文件的操作
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
