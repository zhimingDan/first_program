package com.qqserver.serverservice;

import com.qqcommon.Message;
import com.qqserver.service.ManageClientThread;
import com.qqserver.service.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

//发送离线留言
public class OffLineMessage implements Runnable{

    private Message message;

    //创建函数的时候，将消息传入进去
    public OffLineMessage(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        HashMap<String, ServerConnectClientThread> hm = ManageClientThread.hm;
        while(true){
            if( hm.containsKey(message.getGetter())){ //表示对方在线,此时进行消息的传输
                Socket socket = ManageClientThread.getServerConnectClientThread(message.getGetter()).getSocket();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                    break;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
