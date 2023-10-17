package com.tcp_;

/*
    要求：
    1.编写一个客户端，一个服务端
    2.服务端再8888端口出进行监听
    3.客户端连接到服务端，并发送一张图片"e:\\jiazai.jpg"
    4.服务端接收到图片后，保存到"e:\\yuanShen.jpg",并向客户端发送收到图片后退出
    5.客户端收到服务端发送的消息后退出
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
//服务端
public class TCPFileCopy_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端在8888端口上进行监听");

        Socket socket = serverSocket.accept(); //获取socket对象

        String filePath = "e:\\yuanShen.jpg"; //定义文件的路径
        InputStream inputStream = socket.getInputStream();//读取客户端输入的字节流
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        byte[] bytes = new byte[1024];
        int readLine;
        while((readLine = inputStream.read(bytes)) != -1){ //如果没有读取到文件的末尾，就继续读取
            fileOutputStream.write(bytes,0,readLine); //将读取的数据，写入到该文件中
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("收到你的信息");
//        bufferedWriter.flush();
//        socket.shutdownOutput();

        //关闭所有的流操作，因为后面不会再传数据，因此直接关闭即可(关闭操作包含对数据的刷新)
        bufferedWriter.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
