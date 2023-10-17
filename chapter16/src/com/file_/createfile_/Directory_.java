package com.file_.createfile_;

import org.junit.jupiter.api.Test;

import java.io.File;

//对文件、目录进行删除操作
public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    //判断文件e:\\new1.txt 是否存在，如果存在就删除
    //在java中编程中，目录也是一种文件
    public void method1(){
        File file = new File("e:\\new1.txt");
        if(file.exists()){ //判断是否存在
            if(file.delete()){ //进行删除操作，删除后会返回一个boolean值
                //一定要注意，这里完成了删除操作，只是文件删除了，但是内存中的对象依然没有删除
                //而且该对象还是指向初始化的文件名

                System.out.println(file.getName() + "删除成功");
            }else{
                System.out.println(file.getName() + "删除失败");
            }
        }else{
            System.out.println(file.getName() + "文件不存在");
        }
    }

    @Test
    //判断e:\\demo\\a\\b\\c目录是否存在，如果存在则返回已存在，反之则创建该目录
    //file.getName() -> 只会返回最后一级目录或者文件
    public void method2(){
        File file = new File("e:\\demo\\a\\b\\c");
        if(file.exists()){
            System.out.println(file.getName() + "目录已存在");
        }else{
            if(file.mkdirs()){ //创建多级目录的操作，结果会返回一个boolean值
                System.out.println(file.getName() + "目录以创建");
            }else{
                System.out.println(file.getName() + "目录创建失败");
            }
        }
    }
}
