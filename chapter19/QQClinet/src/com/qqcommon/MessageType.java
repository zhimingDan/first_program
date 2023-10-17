package com.qqcommon;

public interface MessageType {
    //不同的值表示不同的消息类型
    String MESSAGE_LOADING_SUCCESS = "1"; //表示登录成功的消息
    String MESSAGE_LOADING_FAIL = "2"; //表示登录失败的消息
    String MESSAGE_COMM_MES = "3"; //表示普通的消息包
    String MESSAGE_GET_ONLINE_FRIEND = "4"; //表示得到用户在线列表的请求消息
    String MESSAGE_RETURN_ONLINE_FRIEND = "5"; //表示服务端返回在线列表的消息
    String MESSAGE_CLIENT_EXIT = "6"; // 表示客户端请求退出程序
    String MESSAGE_CHAT_OTHER = "7"; //和别人私聊
    String MESSAGE_CHAT_EVERYONE = "8";//群发
    String MESSAGE_SEND_FILE = "9"; //发送文件
}
