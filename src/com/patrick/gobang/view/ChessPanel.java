package com.patrick.gobang.view;

import com.patrick.gobang.entity.UmpireAAA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/29 17:57
 * @Description: TODO
 */
public class ChessPanel extends JPanel {


    public static final int CHESSBOARD_ROW = 15;
    public static final int CHESSBOARD_COLUMN = 15;
    public static final int CHESSBOARD_ORIGIN_X = 45;
    public static final int CHESSBOARD_ORIGIN_Y = 45;
    public static final int CHESSBOARD_SPACE = 40;


    private static ChessPanel chessPanel = new ChessPanel();


    private ChessPanel() {

        this.registerListener();

    }

    public static ChessPanel getInstance() {
        return chessPanel;
    }

    // 绘制整个棋盘
    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);

        this.drawLineHorizontal(graphics);
        this.drawLineVertical(graphics);

    }

    // 绘制单个棋子
    public void fillChessman(int chessmanX, int chessmanY, int player) {

        Color color = player == 1 ? Color.BLACK : Color.WHITE;
        Graphics graphics = this.getGraphics();
        graphics.setColor(color);

        int x = 45 + 40 * chessmanX - 18;
        int y = 45 + 40 * chessmanY - 18;
        graphics.fillOval(x, y, 36, 36);


    }


    // 注册监听器
    private void registerListener() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("----- mouse pressed -----");

                UmpireAAA.getInstance().judge(e.getX(), e.getY());

//                Object object = e.getSource();
//                if (object instanceof ChessPanel) {
//                    System.out.println(object.toString());
//                    ChessPanel chessPanel = (ChessPanel) object;
//                }
            }


        });

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


/*
    // 绘制所有棋子
    public void fillChessmen(Graphics graphics) {

        int x = 1, y = 2;

        System.out.println(x + "...." + y);

        // 外层循环 y 轴坐标，相当于一横一横循环
        for (int j = 0; j < CHESSBOARD_ROW; j++) {
            // 内层循环 x 轴坐标，绘制出横线上的每一个点
            for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
                // 1代表黑棋, -1代表白棋
                if (chessmen[i][j] == 1) {
                    graphics.setColor(Color.BLACK);
                } else if (chessmen[i][j] == -1) {
                    graphics.setColor(Color.WHITE);
                } else {
                    break;
                }

                x = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * i;
                y = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * j;

                System.out.println(x + "...." + y);

                graphics.fillOval(x, y, 36, 36);

            }

        }

    }

*/







}
