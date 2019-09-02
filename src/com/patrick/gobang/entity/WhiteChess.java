package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:30
 * @Description: TODO
 */
public class WhiteChess implements ChessObserver {

    private int steps = 0;


    public WhiteChess(){

        // umpire.attach(this);
        System.out.println("new WhiteChess");
    }

    @Override
    public void onChessDown(int chessmanX, int chessmanY, int player) {
        if (player == -1) {
            steps ++;
            System.out.println("whiteChess Observer, player: " + player + "  steps: " + steps);
        }
    }
}





