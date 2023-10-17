package com.exercise_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//输入流：反序列化
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String filePath = "e:\\a.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(ois.read());
        System.out.println(ois.readInt()); //序列化数据
        System.out.println(ois.readBoolean());
        System.out.println(ois.readDouble());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());

        ois.close();
    }
}
