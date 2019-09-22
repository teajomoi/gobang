package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/20 20:03
 * @Description: TODO
 */
public class BlackPlayer extends AbstractPlayer {


    public BlackPlayer(Umpire2 umpire2, boolean isRobot) {
        super(umpire2, isRobot);

        this.setChessColor(IChessboard.BLACK_CHESS);

    }


    @Override
    public void putChessmanDown(int x, int y) {

        System.out.println("I'm black");

        this.umpire2.judge(x, y);







    }
}
