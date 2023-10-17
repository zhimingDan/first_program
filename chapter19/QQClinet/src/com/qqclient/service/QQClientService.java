package com.qqclient.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

//完成用户登录验证/注册等功能
public class QQClientService {

    private User user = null;

    //因为后面可能会在其他的地方使用到socket，因此将socket变成全局的
    private Socket socket = null;

    //该方法根据用户输入的userId 以及 pwd 到服务器端验证该用户的身份是否合法
    public boolean checkUser(String userId,String pwd) throws IOException, ClassNotFoundException {
         user = new User(userId, pwd);
         socket = new Socket(InetAddress.getLocalHost(),9999);
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
         oos.writeObject(user); //将得到的user对象发送到服务器
         //socket.shutdownOutput();//客户端写入数据完毕
        //然后监听服务端传回的Message对象

         ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
         Message message = (Message) ois.readObject();

        if(message.getMessageType().equals(MessageType.MESSAGE_LOADING_SUCCESS)){ //表示登录成功

            //因为是使用线程进行通讯的，因此如果登录成功，就创建一个和服务器端保持通信的线程
            //创建一个类 -> ClientConnectServerThread (客户端连接服务端的线程)
            //如果服务端传来登录成功的信息，那么就开启一个线程
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();

            //但是为了方便后续的管理，因为可能会开启很多个线程，因此使用集合来进行线程的管理
            //将线程加入到集合中
            ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
            return true;
        }else{
            //如果登录失败的话，这次就没有创建服务端与客户端连接的线程，因此需要关闭socket即可
            socket.close();
            return false;
        }
    }

    public void onlineFriend(){ //申请用户的在线列表
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND); //申请用户在在线列表
        message.setSender(user.getUserId());
        //将该消息对象发送给服务端
        //但是首先要确定是那个线程发送的消息对象
        //通过userId来得到当前的线程对象
        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.hm.get(user.getUserId());
        //通过当前线程对象来获取socket对象
        Socket socket = clientConnectServerThread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message); //将该请求写入到socket中
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clientExit(){ //客户端退出
        Message message = new Message(); //创建一个message对象
        message.setSender(user.getUserId());
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT); //告知服务器客户端要退出的消息

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void chatWithOther(String userId , String content){
        Message message = new Message(); //创建一个消息对象
        message.setSender(user.getUserId()); //发送者的名字
        message.setGetter(userId); //接收者的名字
        message.setSendTime(new Date().toString());
        message.setMessageType(MessageType.MESSAGE_CHAT_OTHER); //设置消息的类型
        message.setContent(content); //设置发送消息的内容

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message); //将私聊的消息发出到服务端
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void chatWithEveryOne(String useId,String allContent){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CHAT_EVERYONE); //设置消息的形式
        message.setSender(useId);
        message.setContent(allContent); //设置消息的内容

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendFile(String getFile,String filePath,String dest) throws IOException{
        Message message = new Message();
        message.setGetter(getFile);  //设置接收者
        message.setMessageType(MessageType.MESSAGE_SEND_FILE); //设置消息的形式
        message.setSender(user.getUserId()); //设置消息的发送者
        message.setFileName(dest);
        FileInputStream fis = new FileInputStream(filePath); //从指定的路径中开始读取文件
        message.setBytes(new byte[(int) new File(filePath).length()]);
        fis.read(message.getBytes()); //将文件读取到字节数据中
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
    }

}
