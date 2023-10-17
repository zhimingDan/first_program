package com.tankgame04;

public class Bomb {
    int x,y; //爆炸地方的横纵坐标
    int life = 9; //生命值
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void bombDown(){
        if(life > 0){
            life--;
        }else{
            isLive = false;
        }
    }
}
