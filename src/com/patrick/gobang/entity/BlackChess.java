package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:37
 * @Description: TODO
 */
public class BlackChess implements ChessObserver {

    public BlackChess(Umpire umpire) {

        umpire.attach(this);
        System.out.println("new BlackChess");
    }

    @Override
    public void onChessDown(int player) {

        if (player == 1) {
            System.out.println("blackChess Observer, player: " + player);
        }
    }
}





