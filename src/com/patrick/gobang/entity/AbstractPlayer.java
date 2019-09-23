package com.patrick.gobang.entity;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/20 20:44
 * @Description: TODO
 */
public abstract class AbstractPlayer implements Observer, Cloneable {

    private boolean isRobot = false;

    protected int chessColor;

    protected Umpire umpire = null;


    public AbstractPlayer(boolean isRobot) {
        this.isRobot = isRobot;
    }

    public AbstractPlayer(Observable observable, int chessColor, boolean isRobot) {
        this.umpire = (Umpire) observable;
        this.chessColor = chessColor;
        this.isRobot = isRobot;

        this.registerObserver(this);

    }


    private void registerObserver(Observer observer) {
        this.umpire.addObserver(observer);
    }



    public int getChessColor() {
        return chessColor;
    }

    public void setChessColor(int chessColor) {
        this.chessColor = chessColor;
    }


    public boolean isRobot() {
        return isRobot;
    }

    public void setRobot(boolean robot) {
        isRobot = robot;
    }


    public abstract void play(int x, int y);






}
