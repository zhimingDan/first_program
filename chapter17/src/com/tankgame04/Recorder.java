package com.tankgame04;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyNum = 0; //击毁的坦克数首先设置为0

    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "e:\\myRecord.txt";
    private static Vector<EnemyTank> vector = null;

    private static Vector<Node_> node_s = new Vector<>();//用来接收从文件中读取的数据


    public static Vector<Node_> readRecord(){//读取记录的函数
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyNum = Integer.parseInt(br.readLine());//从文件中读取击毁坦克的记录
            String line = "";
            while((line = br.readLine()) != null){
                String[] s = line.split(" ");
                Node_ node_ = new Node_(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
                node_s.add(node_); //将得到的数据加入到集合中去
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return node_s; //将得到的集合返回
    }

    //将成绩写入到文件中
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyNum + "");
            bw.newLine();
            for (int i = 0; i < vector.size(); i++) {
                EnemyTank enemyTank = vector.get(i);
                String str = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addNum(){ //击毁的坦克的数量加一
        allEnemyNum++;
    }

    public static int getAllEnemyNum() {
        return allEnemyNum;
    }

    public static void setAllEnemyNum(int allEnemyNum) {
        Recorder.allEnemyNum = allEnemyNum;
    }

    public static Vector<EnemyTank> getVector() {
        return vector;
    }

    public static void setVector(Vector<EnemyTank> vector) {
        Recorder.vector = vector;
    }
}
