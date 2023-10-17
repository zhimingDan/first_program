package com.exercise_.exercise01;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//客户端
//可以发现，当客户端告诉服务端数据传输完毕的时候，此时客户端与服务端之间的数据传输就切断了，此时无法再次写入数据
public class TCPHomeWorkClient {
    public static void main(String[] args) throws IOException {
        //创建一个端口用于接收数据
        ServerSocket serverSocket = new ServerSocket(9998);
        //指定Ip地址和端口号，建立与服务端的连接
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("请输入你要问的问题？");
            String str = scanner.next(); //从键盘输入一个值
            if("exit".equals(str)){
                socket.close();
                bw.close();
                break;
            }
            bw.write(str); //将数据写入到socket中
            bw.newLine();//表示一次数据输出完毕,放置了一个标志位
            bw.flush();


            System.out.println("===等待服务的回复===");
            //接收服务端的回复
            Socket socket1 = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            System.out.println("服务器的回信是：" + br.readLine());
            //关闭流操作，防止造成资源的浪费
            br.close();

        }
        //关闭流操作
        serverSocket.close();
    }
}
