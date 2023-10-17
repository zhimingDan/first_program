package com.chapter08.facetointerface_.command_;

/**
 * 接口中的命令模式：
 * 这个模式比较简单：就是创建一个接口，但是不是立马去实现这个接口，而是具体的方法具体分析，必须等到执行该方法的时候
 * 才能确定
 *
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] arr = {1,2,3};
        Command printCommand = new PrintCommand();
        processArray.process(arr,printCommand);
    }
}
