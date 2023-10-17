package com.tankgame04;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable {

    Fire fires = null;
    Vector<EnemyTank> vector = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //解决敌人坦克之间的碰撞问题
    public boolean toTouchEnemy() {
        //根据当前坦克的不同的朝向，来判断当前坦克是否和其他的坦克进行的碰撞,如果碰撞了，返回true.反之，则返回false
        switch (this.getDirect()) {
            case 0://当前坦克向上的时候
                for (int i = 0; i < vector.size(); i++) {
                    EnemyTank enemyTank = vector.get(i);
                    if (enemyTank != this) { //当前坦克自身不进行碰撞检测
                        //敌人坦克的方向为上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克的左边的坐标为[getX(),getY()]
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()]
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                        //敌人坦克的方向为右左
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()]
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://当前坦克向右的时候
                for (int i = 0; i < vector.size(); i++) {
                    EnemyTank enemyTank = vector.get(i);
                    if (enemyTank != this) { //当前坦克自身不进行碰撞检测
                        //敌人坦克的方向为上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克的左边的坐标为[getX(),getY()]
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+60,getY()]
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                        //敌人坦克的方向为右左
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+60,getY()]
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://当前坦克向下的时候
                for (int i = 0; i < vector.size(); i++) {
                    EnemyTank enemyTank = vector.get(i);
                    if (enemyTank != this) { //当前坦克自身不进行碰撞检测
                        //敌人坦克的方向为上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克的左边的坐标为[getX(),getY()+60]
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()+60]
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                        //敌人坦克的方向为右左
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()+60]
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://当前坦克向左的时候
                for (int i = 0; i < vector.size(); i++) {
                    EnemyTank enemyTank = vector.get(i);
                    if (enemyTank != this) { //当前坦克自身不进行碰撞检测
                        //敌人坦克的方向为上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克的左边的坐标为[getX(),getY()+60]
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()+60]
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                        //敌人坦克的方向为右左
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }

                            //当前坦克的右边的坐标为[getX()+40,getY()+60]
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40) {
                                //表示坦克发生了碰撞
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false; //表示没有碰撞
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

    public void setVector(Vector<EnemyTank> vector) {
        this.vector = vector;
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
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    switch (getDirect()) { //根据坦克的方向进行位移
                        case 0:
                            if (getY() > 0 && !toTouchEnemy()) {
                                moveUp();
                            }
                            break;
                        case 1:
                            if (getX() < 930 && !toTouchEnemy()) {
                                moveRight();
                            }
                            break;
                        case 2:
                            if (getY() < 680 && !toTouchEnemy()) {
                                moveDown();
                            }
                            break;
                        case 3:
                            if (getX() > 0 && !toTouchEnemy()) {
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
