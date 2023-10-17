package com.tankgame04;

//子弹类
public class Fire extends Thread {

    int x, y; //表示子弹的坐标
    int direct; //表示子弹的方向
    int speed = 15; //子弹设计的速度

    boolean isLive = true;
    boolean loop = true;

    public Fire(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0://表示子弹的方向是向上
                    y -= speed;
                    break;
                case 1://表示子弹的方向是向右
                    x += speed;
                    break;
                case 2://表示子弹的方向是向下
                    y += speed;
                    break;
                case 3://表示子弹的方向是向左
                    x -= speed;
                    break;
            }
            System.out.println("(" + x + " , " + y + ")");
            if (!((x >= 0 && x <= 1000) && (y >= 0 && y <= 750))){ //表示子弹已经到达了边界
                System.out.println("子弹已经销毁");
                isLive = false;
                break;
            }
        }
    }
}
