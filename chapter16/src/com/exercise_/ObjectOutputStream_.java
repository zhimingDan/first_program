package com.exercise_;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//对象输出流：序列化操作
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String fileName = "e:\\a.dat";

        //产生异常，将异常抛出
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

        oos.write(100); //这个操作并不表示序列化


        oos.writeInt(100); //写入 int 100
        oos.writeBoolean(true);//写入 boolean true
        oos.writeDouble(1.3);
        oos.writeChar('a');
        oos.writeUTF("hello,world"); //这个是表示写入一个引用类型的数据

        oos.writeObject(new Tiger_(5,"jack")); //写入一个类

        //进行完流的操作之后，一定要关闭流
        oos.close();
    }
}
