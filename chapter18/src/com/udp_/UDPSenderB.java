package com.udp_;

import java.io.IOException;
import java.net.*;

//使用UDP进行数据传输
/*
    1.编写一个接收端A和发送端B
    2.接收端A在端口9999地方等待数据的传输(receive)
    3.发送端向接收端发送数据"hello,明天去吃火锅?"
    4.接收端接收到数据后向发送端回复数据:"好的，明天见！"，再退出
    5.发送端接收到接收端的数据后退出
 */
/*
    TCP数据传输中，客户端的端口号是有TCP/IP协议随机分配的
    UDP数据传输中，发送端和接收端的端口号都需要通过DatagramSocket来进行指定，并且通过DatagramSocket进行发送
 */
//发送端
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //发送端在9998端口处进行数据监听，监听是否有数据发送过来
        DatagramSocket socket = new DatagramSocket(9998);

        //得到要传输的数据，因为String方法中的数据存储形式是UTF-8,而IDEA中的数据形式也是UTF-8，因此不会出现乱码的问题
        byte[] bytes = "hello,明天去吃火锅?".getBytes();

        //将数据封装到packet对象中，该对象通过指定的ip地址以及端口号在网络中进行传输
        DatagramPacket packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.186.1"), 9999);
        //通过该端口将数据发出，UDP中发送数据时，需要自己指定发送端口和接收端口，而TCP发送数据时，系统会随机分配
        //发送端口
        socket.send(packet);



        System.out.println("数据发送完毕，此时进行数据监听");
        socket.receive(packet);
        int length = packet.getLength();
        String str = new String(packet.getData(),0,length);
        System.out.println("接收到的回信为：" + str);

        socket.close();
    }
}
