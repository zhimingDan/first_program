package com.tcp_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class SocketTCP02Client_ {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999); //创建与指定服务器的端口的连接

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());

        socket.shutdownOutput();// 表示输送数据完成，然后这个操作会关闭客户端到服务端的输出流
        // 这样会导致客户端后续无法通过socket对服务端进行流的传输

        //socket.shutdownOutput();//表示输送数据完成


        InputStream inputStream = socket.getInputStream();
        int readLine;
        byte[] bytes = new byte[1024];

        //java中必须设置文件传输结束的标记，否则另一端无法知道你是否传输结束
        while((readLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLine));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
