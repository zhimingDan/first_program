package com.exercise_.exercisereview01;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//使用UDP进行编程
//接收端
public class UDPReceiver {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9999); //接收端在端口9999处进行监听

            byte[] bytes = new byte[1024]; //用来存放数据
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length); //将接收到的数据包存放在datagramPacket对象中
            datagramSocket.receive(datagramPacket); //程序会阻塞在这里一直接收数据包

            //进行拆包操作
            int length = datagramPacket.getLength();
            String s = new String(datagramPacket.getData(), 0, length);
            System.out.println("接收到的数据为：" + s);

            //然后对接收到的数据进行会送
            byte[] bytes1 = "好的，收到来信".getBytes();
            //生成一个指定发送位置的数据包
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getLocalHost(), 9998);
            datagramSocket.send(datagramPacket1); //将该数据包发送出去

            datagramSocket.close(); //关闭流对象，防止造成资源浪费

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
