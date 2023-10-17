package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;
import com.qqserver.serverservice.SendNewsToAll;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

//QQ的服务器端
public class QQServer {
    //因为服务端的端口监听是需要经常使用的
    private ServerSocket serverSocket = null;
    //创建一个集合用来存储合法用户
    //使用ConcurrentHashMap可以处理并发的问题，因为ConcurrentHashMap是线程安全的
    //如果不能让同一个用户同时登录多次，可以用存储线程的集合来进行判断！！
    private static ConcurrentHashMap<String,User> chm = new ConcurrentHashMap<>();

    static{//使用静态代码块来完成对集合的初始化，静态代码块在类加载的时候就完成了初始化
        chm.put("100",new User("100","123456"));
        chm.put("200",new User("200","123456"));
        chm.put("300",new User("300","123456"));
        chm.put("400",new User("400","123456"));
        chm.put("方知",new User("方知","123456"));
        chm.put("月心",new User("月心","123456"));
        chm.put("方知和月心",new User("方知和月心","123456"));
    }

    //定义一个方法，用来判断登录的用户是否是合法用户
    public static boolean checkUser(String userId,User user){
        User user1 = chm.get(userId);
        if(user1 == null){ //如果得到的是null，表示集合中没有该用户
            return false;
        }
        if(!user1.getPassWord().equals(user.getPassWord())){ //如果集合中的该用户的密码和你输入的密码不同
            return false;
        }
        return true;
    }
    public QQServer(){//在创建对象的时候，在构造器里面完成接口的监听
        try {
            //服务器在9999端口处开始监听
            serverSocket = new ServerSocket(9999);
            new Thread(new SendNewsToAll()).start();
            //因为服务器需要一直对端口进行监听，只要监听到一个socket，就回复一个Message对象
            //并且创建一个和客户端连接的线程
            while(true){
                System.out.println("服务器端在9999号端口处进行监听");
                Socket socket = serverSocket.accept(); //如果没有客户端连接，服务端就会阻塞在这里
                //如果监听到socket的话，就读取流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //因为我们是知道固定读取的Uer对象
                User user = (User) ois.readObject();

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                //先死后活：先固定用户名和密码
                if(checkUser(user.getUserId(),user)){
                    //如果用户名和密码正确，此时向客户端写入登录成功的信息
                    message.setMessageType(MessageType.MESSAGE_LOADING_SUCCESS);
                    oos.writeObject(message);
                    //socket.shutdownOutput();

                    //然后此时创建一个线程：将客户端和服务端连接起来
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, user.getUserId());
                    //打开一个线程
                    serverConnectClientThread.start();
                    //为了方便管理所有的线程，此时创建一个类，来管理所有的线程
                    //把该线程对象放入到集合中，来进行管理
                    ManageClientThread.addClientThread(user.getUserId(),serverConnectClientThread);

                    //启动服务端推送线程

                }else{//登录失败
                    System.out.println("用户" + user.getUserId() + "登录失败");
                    message.setMessageType(MessageType.MESSAGE_LOADING_FAIL);
                    oos.writeObject(message);
                    socket.shutdownOutput();
                    //如果登录失败，就关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            //如果服务器端退出了while循环，说明服务器端不在监听，因此需要关闭serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
