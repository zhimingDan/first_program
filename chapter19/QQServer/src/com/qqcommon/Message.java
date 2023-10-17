package com.qqcommon;

import java.io.Serializable;

//客户端和服务器端共有的信息类
public class Message implements Serializable {
    //序列化版本号
    private static final long serialVersionUID = 1L;

    private String sender; //发送者
    private String getter; //接收者
    private String content;//消息的内容
    private String sendTime;//发送时间

    private String fileName; //表示文件名
    //老师分析的结果：必须要设置消息的类型
    private String messageType; //发送的消息的类型
    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
