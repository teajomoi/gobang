package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 15:31
 * @Description: TODO
 */
public class StartGame {

    private Umpire umpire = null;

    private WhiteChess whiteChess = null;
    private BlackChess blackChess = null;

    public StartGame() {

        this.attachObservers();
        System.out.println("start game");

    }


    private void attachObservers() {


        if (umpire == null) umpire = Umpire.getInstance();
        if (whiteChess == null) whiteChess = new WhiteChess(umpire);
        if (blackChess == null) blackChess = new BlackChess(umpire);

        //umpire.attach(whiteChess);
        //umpire.attach(blackChess);


    }


}
