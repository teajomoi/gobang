package com.patrick.gobang.entity;

import com.patrick.gobang.control.GameStat;

import java.awt.*;

public interface IChessboard {


    int CHESSBOARD_ROW = 15;
    int CHESSBOARD_COLUMN = 15;
    int CHESSBOARD_ORIGIN_X = 45;
    int CHESSBOARD_ORIGIN_Y = 45;
    int CHESSBOARD_SPACE = 40;

    int BLACK_CHESS = 1;
    int WHITE_CHESS = -1;



    void mousePressed(double x, double y);

    void repaintChessboard(int chessX, int chessY);

    void paintComponent(Graphics graphics);

    default void resetChessboard(GameStat gameStat) {
        this.resetChessboard(null, gameStat);
    }

    void resetChessboard(IUmpire umpire, GameStat gameStat);



}
