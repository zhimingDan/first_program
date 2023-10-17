package com.chapter12.linkedlist_;

import java.util.LinkedList;

public class LinkedList02_ {
    public static void main(String[] args) {
        //LinkedList中的常用的方法：增，删，改，查
        LinkedList linkedList = new LinkedList();

        //LinkedList的增操作：记得分析源码，自己到时候写一个链表的添加机制，然后回来和源码进行比较

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //LinkedList的删除操作：记得回来分析源码，自己到时候写一个链表的删除机制，然后回来和源码进行比较
        linkedList.remove(); //默认删除第一个节点
    }
}
