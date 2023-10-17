package com.tcp_;

//服务器端的程序

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//对SeverSocket和Socket的解析：
//实际上ServerSocket相当于一个监听器，用于监听某个端口是否有客户端连接，且一个ServerSocket可以接收多个Socket
//而Socket实际上就相当于一个流(两个主机或者客户端与服务端的连接通道)

public class SocketTCP01Server_ {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口进行监听，等待连接(必须要求服务器没有其他的服务在9999端口上进行监听)
        ServerSocket serverSocket = new ServerSocket(9999);

        //2.当没有客户端连接服务器端的9999端口的时候，程序会被阻塞，一直等待客户端的连接
        //  如果有客户端的连接，程序就会继续向下执行
        Socket socket = serverSocket.accept(); //如果有客户端连接，就返回一个socket对象(返回的socket和客户端是同一个socket)
        System.out.println("服务器端的 socket" + socket.getClass());

        //此时服务器端和客户端已经连接起来了，此时来接收客户端的消息
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLine;
        while((readLine = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readLine));
        }

        //操作完成后应该关闭serverSocket socket以及inputStream对象
        serverSocket.close();
        socket.close();
        inputStream.close();
    }
}
