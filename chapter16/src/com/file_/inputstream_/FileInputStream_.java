package com.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

//演示使用read()来读取文件内容
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    //从一个文件中读取文件的内容
    /**
     * 如果在下面文件hello.txt中放入汉字，然后用read()方法去读取，会发生什么？
     * 会发生乱码(虽然汉字也会对应ASCII码)
     * 因为hello.txt的存储方式是unicode的编码方式，这种方式中汉字占3个字节，字母占1个字节
     * 而read()方法每次只能读取一个字节，因此就相当于一个汉字被分三次读取然后分别显示，因此会出现乱码的情况
     */
    public void method1(){
        String fileName = "e:\\hello.txt";
        int readCode;
        //因此，必须先声明一个文件对象
        FileInputStream fileInputStream = null;
        try {
            //FileInputStream fileInputStream = new FileInputStream(fileName); //此时会抛出一个异常,如果是这样的方式定义，那么下面的finally中将没有这个文件对象
            fileInputStream = new FileInputStream(fileName); //此时会抛出一个异常

            //read()方法每次只会读取一个字节！！！当读取到文件末尾的时候，就会返回一个-1，read方法读取的数据会根据ASCII码转换成int类型
            // 且使用read方法也会抛出一个异常，此时一般将下面的文件异常改为父类异常IOException，这样可以捕获前面所有的异常
            //fileInputStream.read();

            while ((readCode = fileInputStream.read()) != -1){ //将文件中读取的数据赋给中间变量，这样的编程思想一定要学！！！
                //读取出来的数据是int类型，因此一定要用char来输出
                System.out.print((char)readCode);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally { //为什么要使用finally呢？因为对一个文件进行操作完成之后，一定要及时关闭对文件的操作
            try {
                fileInputStream.close(); //关闭文件操作也是会抛出异常的，此时将异常捕获即可
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
