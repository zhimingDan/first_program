package com.qqcommon;

import java.io.Serializable;

//客户端和服务器端共有的用户类
public class User implements Serializable { //可序列化
    private static final long serialVersionUID = 1L;
    //分别是用户名和密码
    private String userId;
    private String passWord;

    public User(String userId, String passWord) {
        this.userId = userId;
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
