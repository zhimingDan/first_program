package com.chapter11.stringbuffer_;

//关于StringBuffer的练习题：

public class StringBufferExercise {
    public static void main(String[] args) {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();

        //只是有16个字符的缓冲数组，并不是空间真的有16个
        System.out.println(stringBuffer.length());
        //这里需要看原码，底层调用的是父类AbstractStringBuilder的appendNull方法
        //该方法直接把null直接写入到char[] 数组中去了,也就是说一个空串也是可以连接的

        stringBuffer.append(str);
        System.out.println(stringBuffer.length());//因此这里输出的是4
        System.out.println(stringBuffer); //输出为null

        //通过观察底层原码发现，这里会调用super(str.length() + 16)
        //而我们传进去的是个null，因此这里会抛出空指针异常
        StringBuffer stringBuffer1 = new StringBuffer(str);
        System.out.println(stringBuffer1);

    }
}

