package com.patrick.gobang.view;

import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/28 22:13
 * @Description: TODO
 */
public final class DrawChess {


    public final static int CHESS_ROW = 15;
    public final static int CHESS_COLUMN = 15;
    public final static int ORIGIN_X = 45;
    public final static int ORIGIN_Y = 65;
    public final static int CHESS_SPACE = 40;

    // 储存棋盘上所有棋子的坐标, 便于paint方法绘制棋子
    private static int[][] chessmen = new int[CHESS_ROW][CHESS_COLUMN];


    // 私有化构造方法
    private DrawChess() {}

    public static void insertChess(int x, int y, int player) {
        chessmen[x][y] = player;
    }

    // 画棋盘横线，每条横线 x1 = ORIGIN_X, x2 = ORIGIN_X + 600，固定不变
    public static void drawLineHorizontal(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int x1 = ORIGIN_X;
        int x2 = ORIGIN_X + (CHESS_COLUMN - 1) * CHESS_SPACE;

        for (int i = 0; i < CHESS_ROW; i++) {
            int y = ORIGIN_Y + CHESS_SPACE * i;
            graphics.drawLine(x1, y, x2, y);
        }

    }

    // 画棋盘纵线，每条纵线 y1 y2固定不变
    public static void drawLineVertical(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int y1 = ORIGIN_Y;
        int y2 = ORIGIN_Y + (CHESS_ROW - 1) * CHESS_SPACE;

        for (int i = 0; i < CHESS_COLUMN; i++) {
            int x = ORIGIN_X + CHESS_SPACE * i;
            graphics.drawLine(x, y1, x, y2);
        }

    }



}
