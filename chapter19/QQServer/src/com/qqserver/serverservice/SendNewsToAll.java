package com.qqserver.serverservice;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqserver.service.ManageClientThread;
import com.qqserver.service.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//服务器给所有的在线用户推送消息
public class SendNewsToAll implements Runnable{

    @Override
    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要服务端推送的消息：(输入exit表示退出服务端推送)");
            String news = scanner.next();
            if("exit".equals(news)){
                System.out.println("成功退出服务端推送");
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setMessageType(MessageType.MESSAGE_CHAT_EVERYONE); //服务器推送消息和个人群发实际上是差不多的类型

            HashMap<String, ServerConnectClientThread> hm = ManageClientThread.hm;
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(ManageClientThread.
                            getServerConnectClientThread(iterator.next()).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
