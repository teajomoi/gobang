package com.patrick.gobang.entity;

import java.util.Observable;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/23 22:33
 * @Description: TODO
 */
public class HumanPlayer extends AbstractPlayer {


    public HumanPlayer(Observable observable, int chessColor) {

        super(observable, chessColor);
        this.isRobot = false;

    }


    @Override
    public void play(int x, int y) {
        System.out.println(this.chessColor + " player : " + x + " ... " + y);
        super.umpire.judge(x, y);
    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg != null && this.chessColor == (Integer) arg) {
            System.out.println("Turn to : " + this.chessColor + "\n");

        }
    }
}
