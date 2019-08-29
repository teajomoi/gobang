package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessPanel;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/29 00:06
 * @Description: 棋子实体类
 */
public class Chessman {

    private final int ROW = ChessPanel.CHESS_ROW;
    private final int COLUMN = ChessPanel.CHESS_COLUMN;

    // 二维数组存储棋子坐标
    private int[][] chessmenArray = new int[COLUMN][ROW];

    // 饿汉式单例模式
    private static Chessman chessman = new Chessman();

    private Chessman() {}

    public static Chessman getInstance() {
        return chessman;
    }



    // 清空棋盘
    public void emptyChess() {

        for (int j = 0; j < ROW; j++) {
            for (int i = 0; i < COLUMN; i++) {
                chessmenArray[i][j] = 0;
            }
        }

    }

    public void insertChessman(int x, int y, int player) {
        this.chessmenArray[x][y] = player;

    }

    public int[][] getChessmenArray() {
        return chessmenArray;
    }




}
