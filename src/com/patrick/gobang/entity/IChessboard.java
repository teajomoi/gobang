package com.patrick.gobang.entity;

import com.patrick.gobang.control.AbstractMediator;
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

    void putChessmanOnBoard(int chessX, int chessY, int chessColor);

    void paintComponent(Graphics graphics);

    int[][] getChessmenArray();

    void emptyChessboard();

    void resetChessboard(IUmpire umpire, GameStat gameStat);

    void setMediator(AbstractMediator mediator);


}
