package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqserver.serverservice.OffLineMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//用来管理与客户端通信的线程的类
public class ManageClientThread {
    //用HashMap来分别存储用户的id以及id对应的线程
    public static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    //写一个方法来存储线程
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }

    //写一个方法来返回userId对应的线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    public static void removeClient(String userId){
        hm.remove(userId);
    }
    //编写一个方法，得到用户的在线列表
    public static String getOnlineFriendList(){
        //遍历HashMap的方法，这里使用迭代器iterator
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineName = "";
        while(iterator.hasNext()){
            onlineName += iterator.next() + " ";
        }
        return onlineName;
    }

    public static void returnMessage(Message message){
        if(!hm.containsKey(message.getGetter())){ //如果这个键不存在，就启动一个线程
            new Thread(new OffLineMessage(message)).start();
            return;
        }
        ServerConnectClientThread serverConnectClientThread = hm.get(message.getGetter()); //得到收消息的对应的线程
        Socket socket = serverConnectClientThread.getSocket(); //得到接收者的socket
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message); //将消息写道socket中
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void returnMessageToEveryOne(Message message){
        Iterator<String> iterator = hm.keySet().iterator(); //使用迭代器进行集合遍历

        while(iterator.hasNext()){
            String str = iterator.next();
            if(!str.equals(message.getSender())) {
                ServerConnectClientThread serverConnectClientThread = hm.get(str);//得到每个用户的线程
                Socket socket = serverConnectClientThread.getSocket(); //得到socket对象
                Message message1 = new Message();
                message1.setContent(message.getContent()); //设置消息的内容
                message1.setMessageType(MessageType.MESSAGE_CHAT_EVERYONE); //设置消息的形式
                message1.setSender(message.getSender()); //设置消息的发送者
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
