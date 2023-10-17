package com.qqclient.view;

import com.qqclient.service.QQClientService;

import java.util.Scanner;

//客户端的登录界面
public class QQView {

    private boolean loop = true;

    //因为这个对象是需要经常使用的，用于判断用户是否能够登录以及用户的注册
    private QQClientService qqClientService = new QQClientService();
    //菜单的主界面


    //测试一下功能
    public static void main(String[] args) throws Exception {
        new QQView().mainMenu();
        System.exit(0); //客户端的进程退出了，因此所有的线程都会退出
        /*老师的思路：
            对于客户端：
            1.当运行结束指令的时候，调用方法输出一个Message对象，告诉服务器客户端的这个线程结束了
            2.然后客户端直接运行System.exit(0); 直接结束进程，这样主线程以及所有的子线程就全部退出了

            对于服务器端：
            1.接收到客户端发来的退出消息后，将对应的线程关闭
         */

    }

    private void mainMenu() throws Exception {
        while (loop) {
            System.out.println("========欢迎登录网络通讯系统========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你的选择：");
            String key = scanner.next();
            switch (key) {
                case "1":
                    System.out.print("请输入您的用户名：");
                    String uerId = scanner.next();
                    System.out.print("请输入您的密码：");
                    String passWord = scanner.next();

                    //此时应该将该用户名和密码与服务器中的用户名与密码进行比较，如果相同，则登录成功，反之则登录失败
                    //这里代码比较麻烦，可能需要实现用户的登录/注册等
                    if (qqClientService.checkUser(uerId, passWord)) { //假设登录成功
                        System.out.println("===========欢迎" + uerId + "回来=========");
                        while (loop) { //如果没有点击退出，loop将一直都是true
                            System.out.println("===========欢迎登录网络通信系统的二级菜单=========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = scanner.next();
                            switch (key) {
                                case "1":
                                    //这里调用一个方法，来向服务端发送请求在线用户列表的消息
                                    //因为前面的判断什么的都是用户中的方法，所以，这里也把方法写到用户类中
                                    qqClientService.onlineFriend();
                                    Thread.sleep(200);
                                    break;
                                case "2":
                                    //开始进行群发消息
                                    System.out.print("请输入想要群发的内容：");
                                    String allContent = scanner.next();
                                    //写一个方法，进行传输
                                    qqClientService.chatWithEveryOne(uerId,allContent);
                                    break;
                                case "3":
                                    //开始进行私聊消息
                                    System.out.print("请输入想要私聊的人的名字：");
                                    String getter = scanner.next();
                                    System.out.print("请输入想要私聊的内容：");
                                    String content = scanner.next();
                                    //写一个方法，将该私聊的对象以及内容发出
                                    qqClientService.chatWithOther(getter,content);
                                    Thread.sleep(200);
                                    break;
                                case "4":
                                    //开始进行文件的发送
                                    System.out.print("请输入想要把文件发送给谁：");
                                    String getFile = scanner.next();
                                    System.out.print("请输入文件的地址：");
                                    String filePath = scanner.next();
                                    System.out.print("请输入您想要存放的文件的地址：");
                                    String dest = scanner.next();
                                    //编写一个方法开始进行文件的传输
                                    qqClientService.sendFile(getFile,filePath,dest);
                                    Thread.sleep(200);
                                    break;
                                case "9":
                                    //如果此时选择了9，只是主线程退出了，但是主线程中的子线程还没有退出
                                    //而是在依然监听服务器端发来的消息
                                    System.out.println("正在退出系统");
                                    qqClientService.clientExit(); //发送消息，告诉服务端，客户端退出了
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("用户或密码错误");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
