package com.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战1.3版本，bug依然很多，到后面重新编写

//坦克需要活动的区域，用面向对象编程的思想，将活动的区域独立出来
//因为子弹是运动的，因此必须需要画板能够自动更新，这样才能把子弹的运动状态打印出来
//一定要时刻谨记，画板里面的东西都是会刷新的

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {

    MyTank myTank = null;
    Thread[] threads = new Thread[5];

    static boolean isLive = true;
    //Tank[] tank = new Tank[5]; //定义一个多态数组
    //最好是定义一个集合Vector,因为后面坦克有多线程
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个集合，用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();

    //定义三张图片对象
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        myTank = new MyTank(800, 600);
        int enemyTankNum = 5;
        for (int i = 0; i < enemyTankNum; i++) {
            enemyTanks.add(new EnemyTank(100 * (i + 1), 30));
            threads[i] = new Thread(enemyTanks.get(i));
            threads[i].start();
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom1.jpg"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom2.jpg"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom3.jpg"));

    }

    @Override
    public void paint(Graphics g) { //每次重新调用的是paint函数
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //绘制画板，颜色默认为黑色


        //绘制坦克，专门定义一个绘制坦克的函数
        if(myTank.isLive) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 0);
        }


        //老师绘制坦克的函数：
        for (int i = 0; i < enemyTanks.size(); i++) {
            //得到敌人坦克的集合
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //这样是不行的,因为每次重新绘制的时候，都会把发射炮弹的坐标初始化
                //enemyTank.autoShot();
                if (enemyTank.fires != null && enemyTank.fires.isLive) {
                    g.draw3DRect(enemyTank.fires.x, enemyTank.fires.y, 2, 2, false);
                    if(myTank.isLive) { //如果我的坦克对象还有生命的话，才回去攻击
                        hitTank(enemyTank.fires, myTank);
                    }
                }
            } else {
                enemyTanks.remove(enemyTank);
            }
        }

        //实际上对象没有变，只是因为坐标变化到边界坐标了，因此就不会再次自动的放子弹
        if (myTank.fires != null && myTank.fires.isLive) { //只有当子弹对象不为空且生命不为false的时候，才接着绘制子弹
            g.draw3DRect(myTank.fires.x, myTank.fires.y, 2, 2, false);
            for (int i = 0; i < enemyTanks.size(); i++) {
                hitTank(myTank.fires, enemyTanks.get(i));
            }
        }

        //这样的目的是让爆炸效果更加明显
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }

            //让爆炸的生命值减少
            bomb.bombDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

    }

    /**
     * @param x      表示坦克的起始位置的横坐标
     * @param y      表示坦克起始位置的纵坐标
     * @param g      表示传入一只画笔，因为画笔只有paint函数中才有
     * @param direct 表示坦克的朝向(上下左右)
     * @param type   表示坦克的类型(敌我坦克)
     *               <p>
     *               将绘制坦克的函数直接做成静态的static的
     */

    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //绘制不同的坦克，使用不同颜色的画笔
        switch (type) {
            case 0://表示绘制我方坦克,我方坦克使用青色
                g.setColor(Color.cyan);
                break;
            case 1://表示绘制敌方坦克,地方坦克使用黄色
                g.setColor(Color.yellow);
                break;
        }

        //表示坦克的朝向(0:向上 1:向右 2:向下 3:向左 )
        switch (direct) {
            case 0: //表示坦克朝上
                g.fill3DRect(x, y, 10, 60, false); //绘制坦克的左轮
                g.fill3DRect(x + 30, y, 10, 60, false); //绘制坦克的右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//绘制坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y - 10);//绘制坦克的炮筒
                break;
            case 1://表示坦克朝右，实际上思想不变，还是以左上角的(x,y)为基准进行变化
                g.fill3DRect(x, y, 60, 10, false); //绘制坦克的上轮
                g.fill3DRect(x, y + 30, 60, 10, false); //绘制坦克的下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//绘制坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x + 70, y + 20);//绘制坦克的炮筒
                break;
            case 2: //表示坦克朝下，实际上对于这种对称的坦克，只要指向炮筒的指向改变一下行了
                g.fill3DRect(x, y, 10, 60, false); //绘制坦克的左轮
                g.fill3DRect(x + 30, y, 10, 60, false); //绘制坦克的右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//绘制坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 70);//绘制坦克的炮筒
                break;
            case 3://表示坦克朝左，实际上对于这种对称的坦克，只要指向炮筒的指向改变一下行了
                g.fill3DRect(x, y, 60, 10, false); //绘制坦克的上轮
                g.fill3DRect(x, y + 30, 60, 10, false); //绘制坦克的下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//绘制坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//绘制坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x - 10, y + 20);//绘制坦克的炮筒
                break;
            default: //如果数值不是这个范围，那么这个坦克保持原样不动
                break;
        }
    }

    public void hitTank(Fire fire, Tank tank) {
        switch (tank.getDirect()) {
            //当坦克的方向为上下方向的时候
            case 0:
            case 2:
                if ((fire.x > tank.getX() && fire.x < tank.getX() + 40) && (fire.y > tank.getY() && fire.y < tank.getY() + 60)) {
                    tank.isLive = false;
                    if(tank.fires != null) {
                        tank.fires.isLive = false;
                    }
                    Bomb bomb1 = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb1);
                }
                break;
            //当有坦克被击中的时候，就创建一个Bomb对象
            case 1:
            case 3:
                if ((fire.y > tank.getY() && fire.y < tank.getY() + 40) && (fire.x > tank.getX() && fire.x < tank.getX() + 60)) {
                    tank.isLive = false;
                    if(tank.fires != null) {
                        tank.fires.isLive = false; //当子弹击中敌人坦克的时候，就把子弹的生命变成false
                    }
                    Bomb bomb2 = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb2);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char ch = (char) e.getKeyCode();
        //System.out.println(e.getKeyCode()+"键被按下" + "--->" + ch);
        switch (ch) {
            case 'W':
                myTank.setDirect(0);
                //这样虽然可以实现坦克的移动，但是还是感觉有点low，最好还是自己封装成方法
                //myTank.setY(myTank.getY() - 2);
                if (myTank.getY() > 0) { //当向上方向的坦克在这个返回内，就移动，否则，就不能移动
                    myTank.moveUp();
                }
                break;
            case 'D':
                myTank.setDirect(1);
                //myTank.setX(myTank.getX() + 2);
                if (myTank.getX() < 930) {
                    myTank.moveRight();
                }
                break;
            case 'S':
                myTank.setDirect(2);
                //myTank.setY(myTank.getY() + 2);
                if (myTank.getY() < 680) {
                    myTank.moveDown();
                }
                break;
            case 'A':
                myTank.setDirect(3);
                //myTank.setX(myTank.getX() - 2);
                if (myTank.getX() > 0) {
                    myTank.moveLeft();
                }
                break;
            case 'L':
                myTank.improveSpeed();
                break;
            case 'J':
                //当按下攻击键的时候：如果没有创建过子弹或者在场子弹对象的生命值为false(销毁)的时候，才能继续攻击
                if(myTank.fires == null || myTank.fires.isLive == false) {
                    myTank.shotEnemyTank();
                }
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }
}
