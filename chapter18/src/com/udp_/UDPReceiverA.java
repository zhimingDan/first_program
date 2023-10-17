package com.udp_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接收端
//在UDP编程中：DatagramSocket是用于发送数据(send方法)以及接收数据(receive方法)
//            DatagramPacket是用于对数据进行封装(装包)，且DatagramPacket中含有接收方的ip地址以及端口号
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，在端口号9999处接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //2.因为前面讲过UDP单次的最大传输数据为64k，而且UDP是使用包的形式进行传输的，因此创建一个byte[] 数组来传输数据
        byte[] buf = new byte[1024];
        //创建一个DatagramPacket对象在端口处接收发送过来的数据，并将其存入到字节数组中
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //3.调用接收方法，将通过网络传输的DatagramPacket对象填充到packet对象中
        System.out.println("端口正在进行监听");
        datagramSocket.receive(datagramPacket); //如果监听到发送端的数据时，此时将该数据包放入到datagramPacket对象中

        //对接收的数据包进行拆包
        int length = datagramPacket.getLength();//得到数据的长度
        String str = new String(datagramPacket.getData(),0,length);
        System.out.println("接收到的数据为：" + str);


        //当接收完数据的时候，此时向发送端发送数据
        byte[] bytes = "好的，明天见！".getBytes();
        DatagramPacket datagramPacket1 =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.186.1"), 9998);
        //将数据发送出去
        datagramSocket.send(datagramPacket1);
        //关闭端口，防止资源浪费
        datagramSocket.close();

    }
}
