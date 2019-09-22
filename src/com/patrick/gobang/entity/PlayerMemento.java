package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/21 06:34
 * @Description: TODO
 */
public class PlayerMemento {


    private BlackPlayer blackPlayerBackup;
    private WhitePlayer whitePlayerBackup;


    public void createWhitePlayerMemento(BlackPlayer blackPlayer) {
        //this.blackPlayerBackup = blackPlayer.getBackup();
    }


    public AbstractPlayer createMemento(AbstractPlayer player) {

        return null;

    }


    public void restoreMemento() {



    }



}
