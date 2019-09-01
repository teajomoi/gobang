package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessPanel;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/29 19:24
 * @Description: 单例模式裁判实体类
 */
public class UmpireAAA {

    private int chessmanX = -1;
    private int chessmanY = -1;


    // 1 代表黑方，先手；-1 代表白方，后手。
    private int player = 1;

    private ChessPanel chessPanel = ChessPanel.getInstance();
    private Chessman chessman = Chessman.getInstance();
    private int[][] chessmenArray = chessman.getChessmenArray();


    // 单例模式，私有化构造方法。饿汉式
    private static UmpireAAA umpire = new UmpireAAA();

    private UmpireAAA(){}

    public static UmpireAAA getInstance() {
        return umpire;
    }


    public void judge(double mouseX, double mouseY) {

        // 检查鼠标落点是否有效
        if (checkMousePoint(mouseX, mouseY)) {

            // 给棋盘数组插入棋子坐标及颜色
            chessman.insertChessman(chessmanX, chessmanY, player);

            // 给棋盘绘制棋子
            chessPanel.fillChessman(chessmanX, chessmanY, player);


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

    public void restartGame() {
        chessPanel.repaint();
        chessman.emptyChess();
        player = 1;
    }



    private boolean checkMousePoint(double x, double y) {

        double cellX = (x - ChessPanel.CHESSBOARD_ORIGIN_X) / ChessPanel.CHESSBOARD_SPACE;
        double cellY = (y - ChessPanel.CHESSBOARD_ORIGIN_Y) / ChessPanel.CHESSBOARD_SPACE;

        chessmanX = (int) Math.round(cellX);
        chessmanY = (int) Math.round(cellY);

        // 检查鼠标落点是否超出棋盘范围
        if (chessmanX < 0 || chessmanX >= ChessPanel.CHESSBOARD_COLUMN) { return false; }
        if (chessmanY < 0 || chessmanY >= ChessPanel.CHESSBOARD_ROW) { return false; }

        // 检查鼠标落点是否已经有棋子
        return chessmenArray[chessmanX][chessmanY] == 0;


    }





}
