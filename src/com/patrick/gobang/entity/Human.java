package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:30
 * @Description: TODO
 */
public class Human implements PlayerObserver {

    private String name;
    private int chessColor;

    private int mySteps = 0;


    public Human(String name, int chessColor){

        this.name = name;
        this.chessColor = chessColor;
        // umpire.attach(this);
        System.out.println("new Human");
    }

    @Override
    public void onChessmanDown(int player) {
        if (player == this.chessColor) {
            mySteps++;
            System.out.println("Turn to " + name + " Human Observer, player: " + player + "  mySteps: " + mySteps);
        }
    }
}





