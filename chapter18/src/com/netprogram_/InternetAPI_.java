package com.netprogram_;


import java.net.InetAddress;
import java.net.UnknownHostException;

//相当于InetAddress类中有四个方法，其中两个方法是静态的，分别是为了创建一个InetAddress对象：
// getLocalHost (得到本机的对象) 以及getByName (根据主机名/域名或者ip地址来得到InetAddress对象)
//另外两个方式是根据对象来得到分别得到主机名/域名(getHostName)，或者Ip地址(getHostAddress)

public class InternetAPI_ {
    public static void main(String[] args) throws UnknownHostException {

        //获取本机的InetAddress对象 -> IP地址和本机的地址
        InetAddress localHost = InetAddress.getLocalHost(); //调用该方法会返回一个对象
        //直接输出该对象，应该是调用InetAddress的toString方法
        System.out.println(localHost);//输出结果是本机名＋IP地址：DESKTOP-ANKT5RD/192.168.73.1


        //getByName的静态方法：可以根据主机或者域名来返回InetAddress对象

        //根据主机名来获取InetAddress对象
        InetAddress byName = InetAddress.getByName("DESKTOP-ANKT5RD");
        System.out.println("========");
        System.out.println(byName);


        //根据域名返回InetAddress对象，比如根据域名：www.baidu.com返回InetAddress对象
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println("==============");
        System.out.println(byName1);


        //通过InetAddress对象获取对应的IP地址
        String hostName = byName1.getHostAddress();
        System.out.println("==========");
        System.out.println(hostName);

        //通过InetAddress对象获取对应的主机名/域名
        String hostName1 = byName1.getHostName();
        System.out.println("============");
        System.out.println(hostName1);
    }
}
