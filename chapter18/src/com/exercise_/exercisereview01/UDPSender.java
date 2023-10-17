package com.exercise_.exercisereview01;

/*
    1.编写一个接收端A和发送端B
    2.接收端A在端口9999地方等待数据的传输(receive)
    3.发送端向接收端发送数据"hello,明天去吃火锅?"
    4.接收端接收到数据后向发送端回复数据:"好的，明天见！"，再退出
    5.发送端接收到接收端的数据后退出
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//发送端
public class UDPSender {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9998);
            byte[] bytes = "今天晚上一起吃饭？".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
            datagramSocket.send(datagramPacket); //发送端将数据发出

            //接收数据
            byte[] b = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(b, b.length);
            datagramSocket.receive(datagramPacket1);
            int length = datagramPacket1.getLength();
            System.out.println("接收到的消息为：" + new String(datagramPacket1.getData(),0,length));

            datagramSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
