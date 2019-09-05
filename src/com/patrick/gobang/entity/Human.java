package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:30
 * @Description: TODO
 */
public class Human implements ChessObserver {

    private int steps = 0;


    public Human(){

        // umpire.attach(this);
        System.out.println("new Human");
    }

    @Override
    public void onChessmanDown(int player) {
        if (player == 1) {
            steps ++;
            System.out.println("Human Observer, player: " + player + "  steps: " + steps);
        }
    }
}





