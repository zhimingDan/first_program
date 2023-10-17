package com.file_.objectinputstream_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//对象流也是个处理流
//用反序列化提取文件中的信息
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception{
        //一定要注意：用反序列提取信息的顺序必须和序列化信息的顺序保持一致才行
        //针对对象信息的说明：一定要保证反序列化的对象类型和序列化的对象的全类型(包名+类名)是同一个类型才行！！！
        String fileName = "e:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));//会有异常，直接将异常全部抛出

        //必须保证读取的和写入的一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject(); //读取到的编译类型是Object
        System.out.println(dog);
        ois.close();
    }
}
