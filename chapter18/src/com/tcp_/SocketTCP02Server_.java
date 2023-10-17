package com.tcp_;

/*
    要求如下：
    1.编写一个客户端和服务端，要求服务端在9999端口监听
    2.客户端连接到服务端，向服务端发送hello,server后，接收到服务端发回的hello,client后退出
    3.服务端在接收到客户端发送的hello,server后，向客户端发送hello,client.然后退出
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
@SuppressWarnings({"all"})
public class SocketTCP02Server_ {
    public static void main(String[] args) throws IOException {
        //对9999端口号进行监听
        ServerSocket serverSocket = new ServerSocket(9999);

        //接收监听到的客户端，并返回客户端的socket对象
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLine = 0;
        //因为读取的方式是循环读取的，因此流无法知道是否到达文件的末尾
        //但是如果是直接读取一个Object对象的话，流就是可以知道的
        while((readLine = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readLine));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());

        //为什么这里可以不用申明输出数据完毕呢？
        //因为后面关闭了文件输出流的连接，因此系统会直接认为文件输送完毕

        outputStream.close();//发送完信息后关闭连接

        serverSocket.close();
        socket.close();
        inputStream.close();

    }
}
