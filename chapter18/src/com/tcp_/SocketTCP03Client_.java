package com.tcp_;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;



//使用字符流来进行服务端和客户端之间的传输
//客户端
public class SocketTCP03Client_ {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999); //连接指定的服务器的端口
        System.out.println("客户端的socket: " + socket.getClass());

        //开始进行字符传输，用socket得到一个字节流，然后将字节流用OutputStreamWrite转换流来进行转换
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("你好，服务端！！"); //对服务端进行写操作

        //写完之后必须手动刷新一下，因为这里使用的是Writer类
        bufferedWriter.flush(); //不然不会写入到流中


        //！！！！！

        //如果是写入序列化的数据，那么此时就可以不用使用shutDownOutput来进行半关闭流
        //如果只是普通的写入数据，那么就是需要使用shotDownOutput来告诉接收端，发送端的数据已经发送完毕了

        //！！！！！
        //除了使用socket.shutdownOutput来设置一个结束标记，也可以使用writer.newLine()来设置一个结束标记
        //但是如果使用writer.newLine()//换行符来设置结束标记的话，要求接收方必须使用reader.readLine()来读取，才能算结束
        //表示写操作已经完成
        socket.shutdownOutput(); //这个时候就已经关闭了内部流，因此后面不用再关闭。因此关闭外部流的底层还是关闭内部流

        InputStreamReader osr = new InputStreamReader(socket.getInputStream());
        char[] ch = new char[1024];
        int readLine;

        while((readLine = osr.read(ch)) != -1){
            System.out.println(new String(ch,0,readLine));
        }

        osr.close();
        //osw.close();//内部流已经关闭了，因此不用关闭外部流
        socket.close();


    }
}
