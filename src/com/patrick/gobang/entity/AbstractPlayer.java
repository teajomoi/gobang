package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/20 20:44
 * @Description: TODO
 */
public abstract class AbstractPlayer implements Cloneable {

    private boolean isRobot = false;

    private int chessColor;

    private AbstractPlayer backup;

    protected Umpire2 umpire2 = null;


    public AbstractPlayer(Umpire2 umpire2, boolean isRobot) {
        this.umpire2 = umpire2;
        this.isRobot = isRobot;
    }


    public int getChessColor() {
        return chessColor;
    }

    public void setChessColor(int chessColor) {
        this.chessColor = chessColor;
    }


    //public abstract void restoreMemento();


    public AbstractPlayer getBackup() {
        //return this.clone();
        return null;
    }

    public void setBackup(AbstractPlayer player) {
        this.backup = player;
    }

    public boolean isRobot() {
        return isRobot;
    }

    public void setRobot(boolean robot) {
        isRobot = robot;
    }


    public abstract void putChessmanDown(int x, int y);






//    @Override
//    protected AbstractPlayer clone() {
//        try {
//            return (AbstractPlayer) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }




}
