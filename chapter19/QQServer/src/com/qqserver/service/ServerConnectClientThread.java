package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqserver.serverservice.OffLineMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

//服务端和客户端的连接线程
public class ServerConnectClientThread extends Thread{
    private Socket socket ; //必须要得到与客户端通信的socket
    private String userId; //用来表示客户端的uerId

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.println("用户" + userId + "已连接");
        while(true){ //一直启动客户端的线程，用于读取或者发送数据

            //这里只先读取数据,因为数据都是用Message对象进行传输的
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject(); //读取到数据后
                //下面进行对读取的数据一系列操作
                if(message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){ //表示客户端需要得到用户在线列表
                    //需要得到用户在线列表，那么就要想谁知道有哪些用户是在线的？
                    //很显然，存储用户的线程的集合是知道的，因为只有成功登录的用户，才会开启一个线程

                    System.out.println("用户：" + message.getSender() + "请求得到在线列表");
                    String str = ManageClientThread.getOnlineFriendList(); //得到用户的在线名单，然后返回
                    Message mes = new Message(); //创建一个Message对象
                    mes.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND); //一定要返回消息的类型，用户需要根据消息的类型进行处理
                    mes.setContent(str); //然后设置消息的内容
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(mes); //将内容写入到socket中

                }else if(message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){ //表示客户端请求退出
                    System.out.println("用户" + message.getSender() + "请求退出");
                    socket.close(); //关闭socket通道
                    //移除服务端集合中对应的客户端的线程
                    ManageClientThread.removeClient(message.getSender());
                    break;//退出while()循环
                }else if(message.getMessageType().equals(MessageType.MESSAGE_CHAT_OTHER)){ //表示是私聊的消息
                    System.out.println("用户：" + message.getSender() + " 给用户：" + message.getGetter()
                            + " 发送了一条消息，内容是：" + message.getContent());
                    ManageClientThread.returnMessage(message);
                }else if(message.getMessageType().equals(MessageType.MESSAGE_CHAT_EVERYONE)){//表示是群发消息
                    System.out.println("用户：" + message.getSender() + " 给所有人" +
                            " 发送了一条消息，内容是：" + message.getContent());
                    //写一个方法，来传输消息
                    ManageClientThread.returnMessageToEveryOne(message);
                }else if(message.getMessageType().equals(MessageType.MESSAGE_SEND_FILE)){//表示有文件传输
                    System.out.println("用户：" + message.getSender() + " 给用户：" + message.getGetter()
                            + " 发送了一个文件");
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThread.hm;
                    if(! hm.containsKey(message.getGetter())){ //如果不存在的话，就启动一个线程等待
                        new Thread(new OffLineMessage(message)).start();
                        continue;
                    }
                    //否则，就进行文件传输
                    Socket socket1 = ManageClientThread.getServerConnectClientThread(message.getGetter()).getSocket();
                    ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
                    oos.writeObject(message); //服务器负责转发该文件
                    System.out.println("文件转发成功");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
