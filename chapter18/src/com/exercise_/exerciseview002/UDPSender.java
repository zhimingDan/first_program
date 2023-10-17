package com.exercise_.exerciseview002;

/*
    1.编写一个接收端和发送端，使用UDP来完成编程
    2.接收端在8888端口等待接收数据
    3.发送端向接收端发送四大名著有哪些？
    4.接收端接收到数据后，向发送端返回四大名著的具体书本，否则返回what
    5.接收端和发送端的程序退出
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你的问题？");
            String question = scanner.next();
            byte[] bytes = question.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
            datagramSocket.send(datagramPacket); //将数据包发出

            byte[] bytes1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            datagramSocket.receive(datagramPacket1);
            int length = datagramPacket1.getLength();
            System.out.println(new String(datagramPacket1.getData(),0,length));

            datagramSocket.close();
        } catch (IOException e) {
            System.out.println("异常信息为：" + e.getMessage());
        }
    }
}
