package com.exercise_.exercise02;

import java.io.IOException;
import java.net.*;

public class UDPHomeWorkServer {
    public static void main(String[] args) throws IOException {
        //定义接收端接收数据的端口
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];

        //接收接收端发送过来的数据包，将数据包放到buf中
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        //拆包
        String str = new String(packet.getData(),0,packet.getLength());
        String answer ="";
        if("四大名著有哪些？".equals(str)){
            answer = "《西游记》，《水浒传》，《红楼梦》，《三国演义》";
        }else{
            answer = "what";
        }

        byte[] bytes = answer.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9998);
        socket.send(datagramPacket);
        //关闭流操作
        socket.close();
    }
}
