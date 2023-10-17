package com.file_.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

//对文件进行写入操作
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void method(){
        FileOutputStream fileOutputStream = null;
        String fileName = "e:\\a.txt";

        /**
         *一定要注意什么叫做追加，什么叫做不能追加！！
         * 对于同一个对象，再文件中写入操作，不论你用的write的第几种方法都是追加的
         * 后面的boolean值只是表示不同的对象对文件的操作的时候，是否是追加
         * 比如：你前面创建了一个对象，对文件操作过后，前面的操作都是自动在文件末尾追加的
         * 但是你现在在其他的地方相对该文件进行操作，然后你创建了一个对象，此时对文件的操作就是看你的boolean值了以及
         * 每次重新运行方法的时候，是否是追加，就是看boolean值
         */
        try {
            //以下这种形式表示可以追加
            //fileOutputStream = new FileOutputStream(fileName,true);

            //而下面的形式表示不能追加
            fileOutputStream = new FileOutputStream(fileName);

            //对文件的写入方式有三种
            //方式一：
            fileOutputStream.write('H'); //但是这种方式一次只能写入一个字符

            //方式二：
            String str = "hello world";
            //可以使用String类中的getBytes()方法得到一个字符串数组
            fileOutputStream.write(str.getBytes());

            //方式三：指定byte[] 数组中添加到文件中的字符个数及长度
            fileOutputStream.write(str.getBytes(),0,5);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
