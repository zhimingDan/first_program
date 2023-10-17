package com.exercise_.exercisereview001;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999); //在9999端口处进行监听
            Socket socket = serverSocket.accept(); //此时服务端会卡在这里一直等待着有新的连接建立！！！，如果没有新的连接建立，程序就会一直卡在这里
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();
                System.out.println(str);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                switch(str){
                    case "name":
                        bw.write("my name is nova !!");
                        bw.newLine();
                        bw.flush(); //刷新数据
                        break;
                    case "hobby":
                        bw.write("my hobby is program!!");
                        bw.newLine();
                        bw.flush();
                        break;
                    default:
                        bw.write("what do you say?");
                        bw.newLine();
                        bw.flush();
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("异常信息为：" + e.getMessage());
        }
    }
}
