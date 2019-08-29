package com.patrick.gobang.view;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/29 17:57
 * @Description: TODO
 */
public class ChessPanel extends JPanel {


    public final static int CHESS_ROW = 15;
    public final static int CHESS_COLUMN = 15;
    public final static int ORIGIN_X = 45;
    public final static int ORIGIN_Y = 45;
    public final static int CHESS_SPACE = 40;



    public ChessPanel() {
        super();
    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        this.drawLineHorizontal(graphics);
        this.drawLineVertical(graphics);

        graphics.fillOval(0, 0, 40, 40);


    }

    // 画棋盘横线，每条横线 x1 = ORIGIN_X, x2 = ORIGIN_X + 600，固定不变
    private void drawLineHorizontal(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int x1 = ORIGIN_X;
        int x2 = ORIGIN_X + (CHESS_COLUMN - 1) * CHESS_SPACE;

        for (int i = 0; i < CHESS_ROW; i++) {
            int y = ORIGIN_Y + CHESS_SPACE * i;
            graphics.drawLine(x1, y, x2, y);
        }

    }

    // 画棋盘纵线，每条纵线 y1 y2固定不变
    private void drawLineVertical(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int y1 = ORIGIN_Y;
        int y2 = ORIGIN_Y + (CHESS_ROW - 1) * CHESS_SPACE;

        for (int i = 0; i < CHESS_COLUMN; i++) {
            int x = ORIGIN_X + CHESS_SPACE * i;
            graphics.drawLine(x, y1, x, y2);
        }

    }




}
