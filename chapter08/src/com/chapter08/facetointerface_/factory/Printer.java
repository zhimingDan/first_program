package com.chapter08.facetointerface_.factory;

public class Printer implements Output{

    String[] printData = new String[MAX];
    private int dataNum = 0;
    @Override
    public void out() {
        for(String str : printData){
            if(str == null){
                break;
            }
            System.out.println(str);
        }
    }

    @Override
    public void getData(String mags) {
        if(dataNum >= MAX){
            System.out.println("需要的打印的数据已满");
        }else{
            printData[dataNum++] = mags;
        }
    }
}
