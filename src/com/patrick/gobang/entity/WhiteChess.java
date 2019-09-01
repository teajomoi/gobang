package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:30
 * @Description: TODO
 */
public class WhiteChess implements ChessObserver {


    public WhiteChess(Umpire umpire){

        umpire.attach(this);
        System.out.println("new WhiteChess");
    }

    @Override
    public void onChessDown(int player) {
        if (player == -1) {
            System.out.println("whiteChess Observer, player: " + player);
        }
    }
}





