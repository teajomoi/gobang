package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/20 20:46
 * @Description: TODO
 */
public class WhitePlayer extends AbstractPlayer {


    public WhitePlayer(Umpire2 umpire2, boolean isRobot) {

        super(umpire2, isRobot);
        this.setChessColor(Chessboard.WHITE_CHESS);

    }

    @Override
    public void putChessmanDown(int x, int y) {
        System.out.println("I'm white");

        this.umpire2.judge(x, y);


    }
}
