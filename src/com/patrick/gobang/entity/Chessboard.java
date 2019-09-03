package com.patrick.gobang.entity;


import com.patrick.gobang.view.ChessboardPanel;

import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 14:42
 * @Description: 棋盘实体类
 */
public class Chessboard {

    public static final int CHESSBOARD_ROW = 15;
    public static final int CHESSBOARD_COLUMN = 15;
    public static final int CHESSBOARD_ORIGIN_X = 45;
    public static final int CHESSBOARD_ORIGIN_Y = 45;
    public static final int CHESSBOARD_SPACE = 40;

    private ChessboardPanel chessboardPanel = null;     // 棋盘Panel对象
    private int[][] chessmenArray = null;               // 二维数组存储棋子坐标

    private int lastChessX = -1;            // 最后下的棋子的坐标
    private int lastChessY = -1;
    private int steps = 0;                  // 总步数


    public Chessboard(ChessboardPanel chessboardPanel) {
        this.chessboardPanel = chessboardPanel;
        this.chessmenArray = new int[CHESSBOARD_COLUMN][CHESSBOARD_ROW];
    }


    public void putChessmanOnBoard(int chessX, int chessY, int chessColor) throws IndexOutOfBoundsException {

        this.lastChessX = chessX;
        this.lastChessY = chessY;
        steps++;
        chessmenArray[chessX][chessY] = chessColor;
        System.out.println("last: " + lastChessX + ".." + lastChessY + " steps: " + steps);
        chessboardPanel.repaint();
    }


    public void repaint() {
        chessboardPanel.repaint();
    }


    public void paintComponent(Graphics graphics) {

        drawLineHorizontal(graphics);
        drawLineVertical(graphics);
        if (steps > 0) {
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

                // System.out.println(x + "...." + y);

                graphics.fillOval(chessX, chessY, 36, 36);

            }

        }

    }

    // 高亮最后下的棋子
    private void highlightLastChessman(Graphics graphics) {

        int x = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * lastChessX - 5;
        int y = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * lastChessY - 5;
        graphics.setColor(Color.RED);
        graphics.drawRect(x, y ,10, 10);
    }



    // 绘制单个棋子
    public void fillChessman(int chessmanX, int chessmanY, int chessColor) {

        Color color = chessColor == 1 ? Color.BLACK : Color.WHITE;
        Graphics graphics = chessboardPanel.getGraphics();
        graphics.setColor(color);

        int x = 45 + 40 * chessmanX - 18;
        int y = 45 + 40 * chessmanY - 18;
        graphics.fillOval(x, y, 36, 36);


    }


    // 悔棋
    public void retractLastStep() {

        if (steps <= 0) return;
        System.out.println("Retract");
        //chessmenArray[lastChessX][lastChessY] = 0;
        //steps--;
        //this.repaint();
    }



    // 清空棋盘
    public void emptyChess() {

        lastChessX = -1;
        lastChessY = -1;
        steps = 0;

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




}
