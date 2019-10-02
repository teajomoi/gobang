package com.patrick.gobang.entity;

import com.patrick.gobang.control.GameStat;
import com.patrick.gobang.view.ChessboardPanel;

import java.util.Observable;
import java.util.Random;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/24 00:40
 * @Description: TODO
 */
public class RobotPlayer extends AbstractPlayer implements IRobotPlayer {


    public RobotPlayer(Umpire umpire, int chessColor) {

        super(umpire, chessColor);
        this.isRobot = true;
    }


    @Override
    public void play(int x, int y) {
        this.umpire.judge(x, y);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (arg != null && this.chessColor == (Integer) arg) {
            System.out.println("Turn to : " + this.chessColor);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int[] aaa = chooseOnePoint();
                    play(aaa[0], aaa[1]);

                }
            }).start();
        }
    }


    private int[] chooseOnePoint() {
        int [] aaa = new int[2];
        while (true) {
            aaa[0] = new Random().nextInt(14);
            aaa[1] = new Random().nextInt(14);
            if (GameStat.getInstance().getChessmenArray()[aaa[0]][aaa[1]] == 0) {
                return aaa;
            }


        }

    }


}
