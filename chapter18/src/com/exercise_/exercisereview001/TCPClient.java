package com.exercise_.exercisereview001;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

//完成一下需求
//1.使用字符流的方式，编写一个服务端和客户端程序
//2.客户端发送一个name的时候，服务器端收到以后，回复一个"nova"(nova表示名字)
//3.客户端发送一个hobby的时候，服务器端收到以后，回复一个"编写java程序"
//4.如果客户端发送的不是这两个问题，服务器端回复你说什么呢？

/*
    在本次复习中发现的自己需要注意的问题：
    1.使用字符流进行读写数据的时候，不要随意的使用close()方法，因为底层会关闭socket流，从而导致后续无法写入数据
      此时可以用flush来刷新数据，使得数据能够正确的写入。而且使用字符流的好处就是可以用nextLine()来标志此次写操作完毕

    2.serverSocket.accept() 这个方法并不是监听是否有数据传输，而是监听是否有新的socket流和服务端进行连接，所以
      一定要小心使用serverSocket.accept()方法

 */

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            while(true){
                Scanner scanner = new Scanner(System.in);
                System.out.print("请问您想问服务端什么？");
                String question = scanner.next();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write(question);
                bw.newLine();
                //bw.close(); 这里会把底层的socket关闭的
                bw.flush();

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String answer = br.readLine();
                System.out.println("服务器的回复 ：" + answer);

            }
        } catch (IOException e) {
            System.out.println("异常信息为：" + e.getMessage());
        }
    }
}
