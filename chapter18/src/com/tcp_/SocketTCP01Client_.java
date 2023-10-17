package com.tcp_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//其实出现乱码的根本原因是因为用字节流读取数据的时候，如果每次只读取一个字节，然后输出，这样就会导致乱码
//但是，如果一次性读完文本中所有的数据的时候，或者按照文本存储的形式来读取数据的时候，此时就并不会导致乱码的问题
//并且在Idea中String类型是使用utf-8的形式来读取文字的，因此只要文件的类型是utf-8，就不会出现乱码的情况

//TCP是先建立通道，然后进行数据传输，而UDP是直接传输
//客户端
public class SocketTCP01Client_ {
    public static void main(String[] args) throws IOException {
        //1.连接服务端的ip(也可以值InetAddress对象) + 端口 (因为这里的服务端是主机，因此就使用的是主机的ip地址)
        //  如果连接成功则返回一个socket对象
        //实际上客户端和服务端采用TCP协议进行通信的时候，实际上不止服务端会有个端口，TCP/IP协议会给客户端也随机分配一个
        //端口用于服务端和客户端之间的通信
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端的 Socket" + socket.getClass());

        //2.连接上后，生成Socket对象，通过Socket.getOutputStream 来得到和socket对象相关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,服务器".getBytes());//向服务器端输送信息

        //完成后，应该及时关闭流以及socket对象，防止造成资源的浪费

        outputStream.close();
        socket.close();
    }
}
