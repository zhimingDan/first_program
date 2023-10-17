package com.file_.objectoutputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//使用对象流进行序列化
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //一定要注意：序列化以后的文件保存的格式不是文本格式，而是按照它特定的格式保存的，因此文件后缀可以随意写
        String fileName = "e:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

        //一定要注意，不同的数据类型序列化的方法是有点区别的
        //oos.write(100) //如果直接这样用write的话，那就是保存一个数据，而没有保存数据的类型，不是序列化，且读取的方式也只能是read
        oos.writeInt(100); //底层会进行自动装箱成Integer -> Integer又实现了Serializable 接口，因此可以进行序列化
        oos.writeBoolean(true); //底层会进行自动装箱成Boolean -> Boolean又实现了Serializable 接口，因此可以进行序列化
        oos.writeChar('a');//底层会进行自动装箱成Char-> Char又实现了Serializable 接口，因此可以进行序列化
        oos.writeDouble(1.5);//底层会进行自动装箱成Double -> Double又实现了Serializable 接口，因此可以进行序列化

        //注意，序列化String类型的时候的代码
        oos.writeUTF("hello"); //String 类型是实现了Serializable接口的

        //写入一个对象的时候，该对象要么实现Serializable接口，要么实现Externalizable接口(该接口没有拼写错误)
        oos.writeObject(new Dog("小黄",10));
        //完成流的操作后，关闭流对象
        oos.close();
        System.out.println("序列化成功！！");
    }
}


