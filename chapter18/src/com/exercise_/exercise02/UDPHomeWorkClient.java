package com.exercise_.exercise02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
    1.编写一个接收端和发送端，使用UDP来完成编程
    2.接收端在8888端口等待接收数据
    3.发送端向接收端发送四大名著有哪些？
    4.接收端接收到数据后，向发送端返回四大名著的具体书本，否则返回what
    5.接收端和发送端的程序退出
 */
public class UDPHomeWorkClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要搜索的问题？");
        String str = scanner.next();

        byte[] bytes = str.getBytes();
        DatagramPacket packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        //将内容发出
        socket.send(packet);

        System.out.println("开始监听是否有回信");
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        socket.close();
    }
}
