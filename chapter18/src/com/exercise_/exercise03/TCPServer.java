package com.exercise_.exercise03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(9999);
        String fileName = "";
        //在端口处进行监听
        System.out.println("服务器在监听！！");
        Socket socket = serversocket.accept();
        //读取客户端发送的内容
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        if("jm1".equals(str)){
            fileName = "e:\\jm1.jpg";
        }else{
            fileName = "e:\\yuanshen.jpg";
        }

        //根据地址开始读取文件,因为是图片这种二进制文件，因此采用字节流进行文件读取

        //向接收端会送数据

        OutputStream outputStream = socket.getOutputStream();
        byte[] buf = new byte[1024];
        FileInputStream fis = new FileInputStream(fileName);
        int readLine ;
        while((readLine = fis.read(buf)) != -1){
            outputStream.write(buf,0,readLine);
        }

        //关闭所有的流
        socket.close();
        fis.close();
        br.close();
        serversocket.close();

    }
}
