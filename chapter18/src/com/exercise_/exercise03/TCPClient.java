package com.exercise_.exercise03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

//对于TCP而言，创建了通道两边就可以互相使用，而不需要重新创建
/*
    1.编写客户端和服务端程序
    2.客户端可以输入一个图片文件的名字，服务端接收到文件名后，可以给客户端返回这个文件，如果服务端没有这个文件
    则返回一个默认文件
    3.客户端收到文件后，保存到本地 e:\
 */
@SuppressWarnings({"all"})
public class TCPClient {
    public static void main(String[] args) throws IOException {

        //向某个端口发送数据
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("请输入一张图片的名字");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        outputStream.write(question.getBytes());
        socket.shutdownOutput();//表示已完成传输

        //接收服务端发送回来的信息
        System.out.println("客户端等待服务端传送数据");
        String fileName = "e:\\图片.jpg";
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] bytes = new byte[1024];
        int readLength;
        while((readLength = inputStream.read(bytes)) != -1){
            fos.write(bytes,0,readLength);
        }

        //写入完毕
        System.out.println("接收完成");
        //关闭流
        fos.close();
        socket.close();
    }
}
