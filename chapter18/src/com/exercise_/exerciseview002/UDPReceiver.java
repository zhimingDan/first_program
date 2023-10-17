package com.exercise_.exerciseview002;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@SuppressWarnings({"all"})
public class UDPReceiver {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9999); //接收端在9999端口进行数据的监听
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length); //用来接收数据包的内容
            datagramSocket.receive(datagramPacket); //等待发送端发送的数据

            int length = datagramPacket.getLength();
            String question = new String(datagramPacket.getData(), 0, length);
            if("四大名著有哪些？".equals(question)){
                byte[] bytes1 = "《西游记》《水浒传》《三国演义》《红楼梦》".getBytes();
                DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getLocalHost(), 8888);
                datagramSocket.send(datagramPacket1);
            }else{
                byte[] bytes1 = "what?".getBytes();
                DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getLocalHost(), 8888);
                datagramSocket.send(datagramPacket1);
            }
            datagramSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
