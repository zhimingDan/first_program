package com.chapter12.set_.hashset_;

public class HashSet01_ {
    public static void main(String[] args) {
        //模拟HashSet的底层(HashMap的底层结构(数组 + 链表))
        Node[] table = new Node[16]; //创建一个数组作为主支架

        Node jack = new Node("jack", null); //创建一个Node对象，因为还没有下一个节点，因此next指向null
        table[1] = jack;
        Node tom = new Node("tom", null); //创建了一个新的对象
        jack.next = tom; //jack指向下一个节点，来形成链表
        Node jerry = new Node("jerry", null);
        tom.next = jerry;
        //这样就形成了数组和链表的结构，当链表的结构进一步扩大的时候，就会形成红黑树
        //为什么不直接采用单数组或者单链表呢？
        //因为这样的效率非常的高
    }
}

class Node{
    private Object item;
    public Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
