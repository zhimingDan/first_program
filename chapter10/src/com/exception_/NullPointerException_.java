package com.exception_;

//空指针异常示例
public class NullPointerException_ {
    public static void main(String[] args) {
        String name = "12345";
        System.out.println(name.length()); //这里是输出字符串的长度
        //但是如果此时，把字符串置为空的时候，在输出长度的时候，就会抛出空指针异常
        name = null;
        System.out.println(name.length());
    }
}
