package com.qqclient.service;

import java.util.HashMap;

//用于管理用户的线程的类
public class ManageClientConnectServerThread {

    //用于HashMap集合来管理用户线程，分别传入用户的id,以及对应的线程
    public static HashMap<String , ClientConnectServerThread> hm = new HashMap<>();

    //用一个方法来专门管理这些线程的加入
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread); //将一个线程加入到集合中进行管理
    }

    //通过用户名返回线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }

}
