package com.exercise_.exercise01;

//完成一下需求
//1.使用字符流的方式，编写一个服务端和客户端程序
//2.客户端发送一个name的时候，服务器端收到以后，回复一个"nova"(nova表示名字)
//3.客户端发送一个hobby的时候，服务器端收到以后，回复一个"编写java程序"
//4.如果客户端发送的不是这两个问题，服务器端回复你说什么呢？

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//因为是客户端和服务器端，因此采用TCP的方式进行编程
//服务器端
public class TCPHomeworkServer {
    public static void main(String[] args) throws IOException {
        //创建一个端口，用来接收数据
        ServerSocket serverSocket = new ServerSocket(9999);

        while(true){
            //端口接收客户端的socket
            Socket socket = serverSocket.accept();
            //使用转换流将接收的字节流转换成字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str = br.readLine();
            switch(str){
                case "name" :
                    Socket socket1 = new Socket(InetAddress.getLocalHost(), 9998);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                    bw.write("my name is nova");
                    bw.newLine();
                    bw.close();
                    break;
                case "hobby":
                    Socket socket2 = new Socket(InetAddress.getLocalHost(), 9998);
                    BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
                    bw2.write("my hobby is 编写java程序");
                    bw2.newLine();
                    bw2.close();
                    break;
                default:
                    Socket socket3 = new Socket(InetAddress.getLocalHost(), 9998);
                    BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(socket3.getOutputStream()));
                    bw3.write("对不起，无法回答 "+str);
                    bw3.newLine();
                    bw3.close();
                    break;
            }
        }

    }
}
