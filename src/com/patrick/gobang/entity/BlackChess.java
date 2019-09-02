package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:37
 * @Description: TODO
 */
public class BlackChess implements ChessObserver {

    private int steps = 0;

    public BlackChess() {

        // umpire.attach(this);
        System.out.println("new BlackChess");
    }

    @Override
    public void onChessDown(int chessmanX, int chessmanY, int player) {

        if (player == 1) {
            steps ++;
            System.out.println("blackChess Observer, player: " + player + "  steps: " + steps);
        }
    }
}





