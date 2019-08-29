package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessPanel;

import javax.swing.JPanel;
import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/29 19:24
 * @Description: 单例模式裁判实体类
 */
public class Umpire {

    private int chessmanX = -1;
    private int chessmanY = -1;


    // 1 代表黑方，先手；-1 代表白方，后手。
    private int player = 1;

    private Chessman chessman = Chessman.getInstance();
    private int[][] chessmenArray = chessman.getChessmenArray();


    // 单例模式，私有化构造方法。饿汉式
    private static Umpire umpire = new Umpire();

    private Umpire(){}

    public static Umpire getInstance() {
        return umpire;
    }


    public void judge(double mouseX, double mouseY, ChessPanel chessPanel) {

        if (checkMousePoint(mouseX, mouseY)) {

            // 给棋盘数组插入棋子坐标及颜色
            chessman.insertChessman(chessmanX, chessmanY, player);

            // 给棋盘绘制棋子
            // chessPanel.fillChessman(chessmanX, chessmanY);

            Color color = player == 1 ? Color.BLACK : Color.WHITE;
            Graphics graphics = chessPanel.getGraphics();
            graphics.setColor(color);
            int x = 45 + 40 * chessmanX - 18;
            int y = 45 + 40 * chessmanY - 18;
            graphics.fillOval(x, y, 36, 36);


            // 交换棋手
            player *= -1;

            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 15; i++) {
                    System.out.print(chessmenArray[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }



    }




    private boolean checkMousePoint(double x, double y) {

        double cellX = (x - ChessPanel.ORIGIN_X) / ChessPanel.CHESS_SPACE;
        double cellY = (y - ChessPanel.ORIGIN_Y) / ChessPanel.CHESS_SPACE;

        chessmanX = (int) Math.round(cellX);
        chessmanY = (int) Math.round(cellY);

        // 检查鼠标落点是否超出棋盘范围
        if (chessmanX < 0 || chessmanX >= ChessPanel.CHESS_COLUMN) { return false; }
        if (chessmanY < 0 || chessmanY >= ChessPanel.CHESS_ROW) { return false; }

        // 检查鼠标落点是否已经有棋子
        return chessmenArray[chessmanX][chessmanY] == 0;


    }




}
