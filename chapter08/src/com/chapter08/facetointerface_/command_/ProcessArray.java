package com.chapter08.facetointerface_.command_;

public class ProcessArray {
    public void process(int[] target,Command com){
        com.process(target);
    }
}
