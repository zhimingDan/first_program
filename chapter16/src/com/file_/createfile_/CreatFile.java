package com.file_.createfile_;

import java.io.File;
import java.io.IOException;

//创建一个文件
public class CreatFile {
    public static void main(String[] args) {
        creat01(); //多次运行，并不会重新创建
        creat02();
        creat03();
    }

    //方式1： new File(String file) //根据路径直接创建
    public static void creat01(){
        String filePath = "e:\\new1.txt"; //这里盘符后面必须两个\，因为\是转义字符，因此需要两个
        File file = new File(filePath);
        //实际上此时只是new了一个对象，还没有真正的创建一个文件，此时创建的对象还只是在内存中，与文件没有任何的关系



        //需要调用方法，才能完成文件的创建(只有调用了方法，才会真正的完成文件的创建)
        try {
            file.createNewFile(); //此时会有一个编译异常，可以选择抛出，也可以选择捕获
            System.out.println("方式1：文件创建成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //方法2： new File(File file, String child); //采用父目录路径 ＋ 子文件名的形式创建
    //加入我要创建 e:\new2.txt ,那么e:\就是父目录路径，而new2.txt就是子目录路径
    public static void creat02(){
        File parentFile = new File("e:\\");
        String fileName = "new2.txt";
        File file = new File(parentFile, fileName); //此时还没有真正创建对象

        try {
            file.createNewFile(); //此时才是真正的完成了文件的创建
            System.out.println("方式2：文件创建成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //方式3： new File(String parent,String child) //采用父目录 ＋ 子目录的方式创建

    public static void creat03(){
        String parent = "e:\\";  //或者 String parent = "e:/";  //都是可以的，但是还是推荐前面那种方式
        String child = "new03.txt";
        File file = new File(parent, child);

        try {
            file.createNewFile();
            System.out.println("方式3：文件创建成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
