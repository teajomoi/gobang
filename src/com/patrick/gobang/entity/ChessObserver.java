package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:17
 * @Description: 棋手抽象类：观察者
 */
public interface ChessObserver {


    //void onChessmanDown(int chessmanX, int chessmanY, int currentPlayer);
    void onChessmanDown(int currentPlayer);


}
