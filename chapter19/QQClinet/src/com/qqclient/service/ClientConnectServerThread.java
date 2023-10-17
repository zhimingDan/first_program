package com.qqclient.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//用户连接服务器的线程
public class ClientConnectServerThread extends Thread{
    //因为网络中都是通过socket进行通信的，因此需要得到该线程与服务器建立的socket通道
    private Socket socket;
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    //启动一个线程
    @Override
    public void run() {
        System.out.println("用户线程启动成功");
        Scanner scanner = new Scanner(System.in);
        while(true){ //此时客户端只需要一直接收服务端发送来的消息即可
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //读取服务端的信息
                Message message = (Message) ois.readObject();

                //读取服务端的回信
                if(message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){//表示得到了用户列表
                    //肯定是内容，并且在服务器端规定写入的方式为：用户1 用户2 用户3
                    String content = message.getContent();
                    //因此用空格来分割用户
                    String[] str = content.split(" ");
                    System.out.println("==========在线用户列表如下===========");
                    for (int i = 0; i < str.length; i++) {
                        System.out.println("用户1： " + str[i]);
                    }
                }else if(message.getMessageType().equals(MessageType.MESSAGE_CHAT_OTHER)){ //判断这个消息是否是给当前用户的
                    //写一个方法专门来传递消息的内容
                    System.out.println("\n用户：" + message.getSender() + "给您发送了一条消息");
                    System.out.println("内容是：" + message.getContent());
                }else if(message.getMessageType().equals(MessageType.MESSAGE_CHAT_EVERYONE)){
                    System.out.println("\n用户：" + message.getSender() + "给您发送了一条消息");
                    System.out.println("内容是：" + message.getContent());
                }else if(message.getMessageType().equals(MessageType.MESSAGE_SEND_FILE)){ //表示服务器有消息发送回来
                    System.out.println("\n用户：" + message.getSender() + "给您发送了一个文件");
                    FileOutputStream fos = new FileOutputStream(message.getFileName()); //创建一个流对象
                    fos.write(message.getBytes()); //将文件写进去
                    fos.close();
                    System.out.println("文件存放成功");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
