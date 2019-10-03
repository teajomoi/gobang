package com.patrick.gobang.entity;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/20 20:44
 * @Description: TODO
 */
public abstract class AbstractPlayer implements Observer {

    protected boolean isRobot;

    protected int chessColor;

    protected Umpire umpire = null;


    public AbstractPlayer(Observable observable, int chessColor) {
        this.umpire = (Umpire) observable;
        this.chessColor = chessColor;

        this.registerObserver(this);

    }


    private void registerObserver(Observer observer) {
        this.umpire.addObserver(observer);
    }



    public int getChessColor() {
        return chessColor;
    }


    public boolean isRobot() {
        return isRobot;
    }


    public abstract void play(int x, int y);






}
