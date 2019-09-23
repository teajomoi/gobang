package com.patrick.gobang.entity;


import com.patrick.gobang.control.GameStatus;
import com.patrick.gobang.view.ChessboardPanel;

import java.awt.*;
import java.util.Arrays;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 14:42
 * @Description: 棋盘实体类
 */
public class Chessboard implements IChessboard {

    private ChessboardPanel chessboardPanel = null;     // 棋盘Panel对象
    private int[][] chessmenArray = null;               // 二维数组存储棋子坐标
    private int[] chessmanBorder = null;                // 已下棋子的坐标边界，左上右下。

    private int lastChessX = -1;            // 最后下的棋子的坐标
    private int lastChessY = -1;


    public Chessboard(ChessboardPanel chessboardPanel) {
        this.chessboardPanel = chessboardPanel;
        this.chessmenArray = new int[CHESSBOARD_COLUMN][CHESSBOARD_ROW];
        this.chessmanBorder = new int[4];
        Arrays.fill(chessmanBorder, 7);
    }


    public void putChessmanOnBoard(int chessX, int chessY, int chessColor) throws IndexOutOfBoundsException {

        this.lastChessX = chessX;
        this.lastChessY = chessY;
        updateChessmanBorder(chessX, chessY);

        chessmenArray[chessX][chessY] = chessColor;

        chessboardPanel.repaint();
    }

    private void updateChessmanBorder(int chessX, int chessY) {
        if (chessX < chessmanBorder[0]) chessmanBorder[0] = chessX;
        if (chessY < chessmanBorder[1]) chessmanBorder[1] = chessY;
        if (chessX > chessmanBorder[2]) chessmanBorder[2] = chessX;
        if (chessY > chessmanBorder[3]) chessmanBorder[3] = chessY;

        //for (int i : chessmanBorder) System.out.print(i + "..");
    }


    public void paintComponent(Graphics graphics) {

        drawLineHorizontal(graphics);
        drawLineVertical(graphics);
        if (GameStatus.steps > 0) {
            fillAllChessmen(graphics);
            highlightLastChessman(graphics);
        }

    }


    // 画棋盘横线，每条横线 x1 = CHESSBOARD_ORIGIN_X, x2 = CHESSBOARD_ORIGIN_X + 600，固定不变
    private void drawLineHorizontal(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int x1 = CHESSBOARD_ORIGIN_X;
        int x2 = CHESSBOARD_ORIGIN_X + (CHESSBOARD_COLUMN - 1) * CHESSBOARD_SPACE;

        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            int y = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * i;
            graphics.drawLine(x1, y, x2, y);
        }

    }

    // 画棋盘纵线，每条纵线 y1 y2固定不变
    private void drawLineVertical(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int y1 = CHESSBOARD_ORIGIN_Y;
        int y2 = CHESSBOARD_ORIGIN_Y + (CHESSBOARD_ROW - 1) * CHESSBOARD_SPACE;

        for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
            int x = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * i;
            graphics.drawLine(x, y1, x, y2);
        }

    }

    
    // 绘制所有棋子
    private void fillAllChessmen(Graphics graphics) {

        // 外层循环 y 轴坐标，相当于一横一横循环
        for (int y = 0; y < CHESSBOARD_ROW; y++) {
            // 内层循环 x 轴坐标，绘制出横线上的每一个点
            for (int x = 0; x < CHESSBOARD_COLUMN; x++) {
                // 1代表黑棋, -1代表白棋
                if (chessmenArray[x][y] == 1) {
                    graphics.setColor(Color.BLACK);
                } else if (chessmenArray[x][y] == -1) {
                    graphics.setColor(Color.WHITE);
                } else {
                    continue;
                }

                int chessX = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * x - 18;
                int chessY = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * y - 18;


                graphics.fillOval(chessX, chessY, 36, 36);

            }

        }

    }

    // 高亮最后下的棋子
    private void highlightLastChessman(Graphics graphics) {

        int x = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * lastChessX - 18;
        int y = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * lastChessY - 18;
        graphics.setColor(Color.RED);
        graphics.drawOval(x, y, 36, 36);
    }



//    // 绘制单个棋子
//    public void fillChessman(int chessmanX, int chessmanY, int chessColor) {
//
//        Color color = chessColor == 1 ? Color.BLACK : Color.WHITE;
//        Graphics graphics = chessboardPanel.getGraphics();
//        graphics.setColor(color);
//
//        int x = 45 + 40 * chessmanX - 18;
//        int y = 45 + 40 * chessmanY - 18;
//        graphics.fillOval(x, y, 36, 36);
//
//
//    }


    // 悔棋
    public void retractLastStep() {

        if (GameStatus.steps <= 0) return;
        System.out.println("Retract");
        //chessmenArray[lastChessX][lastChessY] = 0;
        //steps--;
        //this.repaint();
    }



    // 清空棋盘
    public void emptyChessboard() {

        lastChessX = -1;
        lastChessY = -1;

        Arrays.fill(chessmanBorder, 7);

        for (int y = 0; y < CHESSBOARD_ROW; y++) {
            for (int x = 0; x < CHESSBOARD_COLUMN; x++) {
                chessmenArray[x][y] = 0;
            }
        }

        // 重绘棋盘
        chessboardPanel.repaint();

    }


    public int[][] getChessmenArray() {
        return chessmenArray;
    }

    public int[] getChessmanBorder() {
        return chessmanBorder;
    }




}
