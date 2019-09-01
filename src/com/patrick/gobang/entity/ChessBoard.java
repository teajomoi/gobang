package com.patrick.gobang.entity;


import com.patrick.gobang.view.ChessboardPanel;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 14:42
 * @Description: TODO
 */
public class ChessBoard implements ChessObserver {

    private final int ROW = ChessboardPanel.CHESSBOARD_ROW;
    private final int COLUMN = ChessboardPanel.CHESSBOARD_COLUMN;

    // 二维数组存储棋子坐标
    private int[][] chessmenArray = new int[COLUMN][ROW];

    // 饿汉式单例模式
    private static ChessBoard chessBoard = new ChessBoard();

    private ChessBoard() {}

    public static ChessBoard getInstance() {
        return chessBoard;
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




    @Override
    public void onChessDown(int player) {

    }





}
