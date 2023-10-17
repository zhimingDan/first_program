package com.tcp_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TCPFileCopy_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String filePath = "e:\\jiazai.jpg";

        //对于照片这种二进制文件，使用字节流进行传输
        //首先先从客户端对应的路径中读取图片

        byte[] bytes = new byte[1024];
        InputStream fileReader = new FileInputStream(filePath);
        OutputStream outputStream = socket.getOutputStream();
        int readLine;
        while((readLine = fileReader.read(bytes)) != -1){
            outputStream.write(bytes,0,readLine);
        }

        //一定要告诉服务端，已经停止发送数据了
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        outputStream.close();
        fileReader.close();
        socket.close();
    }
}
