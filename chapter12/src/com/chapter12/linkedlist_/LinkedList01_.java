package com.chapter12.linkedlist_;

//简单模拟一下链表
public class
LinkedList01_ {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        //上面创建的对象相互之间是没有关联的，现在使用next和prev将各个对象之间联系起来,形成一个双向链表
        //顺着方向指向
        //jack -> tom -> hsp
        jack.next = tom;
        tom.next = hsp;

        //逆着方向指向：
        //hsp -> tom ->jack
        hsp.prev = tom;
        tom.prev = jack;

        Node first = jack; //让一个头指向列表，就是双向链表的头结点
        Node last = hsp;//双向链表的尾结点
        System.out.println("==============================");
        //从头到尾循环遍历链表
        while(true){
            if(first == null){ //如果首节点为空，那么就退出
                break;
            }
            System.out.println(first);
            first = first.next;  //让首节点指向下一个节点
        }
        System.out.println("==============================");
        //从尾到头的遍历
        while(true){
            if(last == null){ //如果尾节点为空，那么就退出
                break;
            }
            System.out.println(last);
            last = last.prev;  //让首节点指向上一个节点
        }

        //如果想要再插入一个人的话，只要创建一个对象，然后让这个对象的next以及prev分别指向
        //将这个对象插入到tom和老韩之间：
        Node smith = new Node("smith");
        smith.next = hsp;
        smith.prev = tom;
        hsp.prev = smith;
        tom.next = smith;
        System.out.println("==============================");
        //这里需要重置last，因为此时已经指到第一个人了
        last = hsp;
        while(true){
            if(last == null){ //如果尾节点为空，那么就退出
                break;
            }
            System.out.println(last);
            last = last.prev;  //让首节点指向上一个节点
        }
    }
}

class Node{
    public Node next;
    public Node prev;
    public Object item;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
