package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/19 21:48
 * @Description: TODO
 */
public class PlayerFactory {


    public static PlayerObserver createHumanPlayer(String name, int chessColor) {
        return new Human(name , chessColor);

    }

    public static PlayerObserver createRobotPlayer(String name, int chessColor) {
        return new Robot(Umpire.getInstance(), name, chessColor);
    }


}
