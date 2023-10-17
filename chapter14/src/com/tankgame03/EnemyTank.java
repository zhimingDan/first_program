package com.tankgame03;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable {

    Fire fires = null;


    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //敌人坦克的自动攻击函数
    public void autoShot() {

        switch (getDirect()) { //根据当前坦克的方向，进行自动攻击
            case 0: //表示向上
                fires = new Fire(getX() + 20, getY() - 10, getDirect());
                break;
            case 1: //表示向右
                fires = new Fire(getX() + 70, getY() + 20, getDirect());
                break;
            case 2: //表示向下
                fires = new Fire(getX() + 20, getY() + 70, getDirect());
                break;
            case 3: //表示向左
                fires = new Fire(getX() - 10, getY() + 20, getDirect());
                break;
        }
        fires.start(); //调用线程
    }

    //老韩忠告：一旦写多线程，就一定要考虑线程什么时候退出的问题
    @Override
    public void run() {
        while (true) { //每隔1s，自动变换方向
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setDirect((int) (Math.random() * 4));
            autoShot(); // 每次变化方向以后，就进行自动攻击

            //根据当前坦克的方向进行移动
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    switch (getDirect()) { //根据坦克的方向进行位移
                        case 0:
                            if (getY() > 0) {
                                moveUp();
                            }
                            break;
                        case 1:
                            if(getX()<930) {
                                moveRight();
                            }
                            break;
                        case 2:
                            if(getY()<680) {
                                moveDown();
                            }
                            break;
                        case 3:
                            if(getX()>0) {
                                moveLeft();
                            }
                            break;
                    }
                }
            }
            if (!isLive) {
                break;
            }
        }
        fires.loop = false;
    }

}
