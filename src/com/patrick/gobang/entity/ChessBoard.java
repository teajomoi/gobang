package com.patrick.gobang.entity;


import com.patrick.gobang.view.ChessboardPanel;

import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 14:42
 * @Description: 棋盘实体类，饿汉式单例模式
 */
public class ChessBoard implements ChessObserver {

    private final int ROW = ChessboardPanel.CHESSBOARD_ROW;
    private final int COLUMN = ChessboardPanel.CHESSBOARD_COLUMN;

    private ChessboardPanel chessboardPanel = ChessboardPanel.getInstance();

    // 二维数组存储棋子坐标
    private int[][] chessmenArray = new int[COLUMN][ROW];

    // 饿汉式单例模式
    private static ChessBoard chessBoard = new ChessBoard();

    private ChessBoard() {}

    public static ChessBoard getInstance() {
        return chessBoard;
    }


    @Override
    public void onChessDown(int chessmanX, int chessmanY, int player) {

        System.out.println("chess board observer");
        this.insertChessman(chessmanX, chessmanY, player);
        this.fillChessman(chessmanX, chessmanY, player);

    }



    // 清空棋盘
    public void emptyChess() {

        for (int j = 0; j < ROW; j++) {
            for (int i = 0; i < COLUMN; i++) {
                chessmenArray[i][j] = 0;
            }
        }

    }

    public void insertChessman(int x, int y, int player) throws IndexOutOfBoundsException {

        this.chessmenArray[x][y] = player;

    }

    public int[][] getChessmenArray() {
        return chessmenArray;
    }




    // 绘制单个棋子
    public void fillChessman(int chessmanX, int chessmanY, int player) {

        Color color = player == 1 ? Color.BLACK : Color.WHITE;
        Graphics graphics = chessboardPanel.getGraphics();
        graphics.setColor(color);

        int x = 45 + 40 * chessmanX - 18;
        int y = 45 + 40 * chessmanY - 18;
        graphics.fillOval(x, y, 36, 36);


    }


}
