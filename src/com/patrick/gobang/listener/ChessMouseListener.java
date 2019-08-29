package com.patrick.gobang.listener;

import com.patrick.gobang.view.DrawChess;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/28 21:34
 * @Description: TODO
 */
public class ChessMouseListener implements MouseListener {


    // 1 代表黑棋，先手；-1 代表白棋，后手。
    private int player = 1;

    @Override
    public void mouseClicked(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();

        double cellX = (x - DrawChess.ORIGIN_X) / DrawChess.CHESS_SPACE;
        double cellY = (y - (DrawChess.ORIGIN_Y - 20)) / DrawChess.CHESS_SPACE;

        int chessX = (int) Math.round(cellX);
        int chessY = (int) Math.round(cellY);

        if (chessX >= 0 && chessX <= 14 && chessY >= 0 && chessY <= 14) {

        }



        System.out.println("x: " + x + ",     y: " + y);
        System.out.println(cellX + "....." + cellY);
        System.out.println(chessX + "......" + chessY);



    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
