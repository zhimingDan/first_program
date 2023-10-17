package com.tcp_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



//使用字符流来进行服务器和客户端之间的传输
//服务器
public class SocketTCP03Server_ {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);//服务器创建一个端口，并对端口进行监听

        Socket socket = serverSocket.accept(); //端口接收客户端的Socket
        System.out.println("服务端的socket: " + socket.getClass());

        //socket对象中只提供了字节流的传输，如果要通过字符流进行传输，此时则需要使用流的转换
        //观察可以发现:是可以通过socket.getInputStream读取字符流的
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());//输出客户端接收到的信息
        System.out.println("服务器已收到客户端的消息");


        //这里是因为后面有关闭流的操作，因此会正确的写入（这个后面就不用处理流来进行处理了）
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        osw.write("你好，客户端！！");

        //一般是后打开的先关闭
        //关闭所有的流，防止资源浪费
        osw.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
