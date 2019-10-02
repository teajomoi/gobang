package com.patrick.gobang.entity;


import com.patrick.gobang.control.GameStat;
import com.patrick.gobang.view.ChessboardPanel;

import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 14:42
 * @Description: 棋盘实体类
 */
public class Chessboard implements IChessboard {

    private ChessboardPanel chessboardPanel = null;     // 棋盘Panel对象
    private static Chessboard chessboard = null;

    private IUmpire umpire;
    private GameStat gameStat = null;
    private int[][] chessmenArray = null;               // 二维数组存储棋子坐标

    private int lastChessX = -1;            // 最后下的棋子的坐标
    private int lastChessY = -1;


    private Chessboard(ChessboardPanel chessboardPanel) {
        this.chessboardPanel = chessboardPanel;
    }


    public static Chessboard createChessboard(ChessboardPanel chessboardPanel) {

        chessboard = chessboardPanel.isCreateChessboard() ? new Chessboard(chessboardPanel) : null;
        return chessboard;

    }


    public static Chessboard getChessboard() {
        return chessboard;

    }


    @Override
    public void mousePressed(double mouseX, double mouseY) {
//        if (mediator == null) {
//            System.out.println("mediator == null...");
//        } else {
//            mediator.execute(mediator.CHECK_MOUSE_POINT, x, y);
//        }

        System.out.println("------------- mouse pressed ---------------");

        if (gameStat == null || !gameStat.isGameRunning()) {
            System.out.println("Game is not running.");
            return;
        }

        double cellX = (mouseX - IChessboard.CHESSBOARD_ORIGIN_X) / IChessboard.CHESSBOARD_SPACE;
        double cellY = (mouseY - IChessboard.CHESSBOARD_ORIGIN_Y) / IChessboard.CHESSBOARD_SPACE;

        int indexX = (int) Math.round(cellX);
        int indexY = (int) Math.round(cellY);


        if (isPointValid(indexX, indexY)) {

            //umpire.notifyObservers(new int[]{gameStat.getCurrentPlayer(), indexX, indexY});

            umpire.selectPlayer(indexX, indexY);

//            int currentPlayer = gameStat.getCurrentPlayer();
//
//            if (currentPlayer == IChessboard.BLACK_CHESS) {
//                if (!blackPlayer.isRobot()) {
//                    blackPlayer.play(indexX, indexY);
//                }
//            } else if (currentPlayer == IChessboard.WHITE_CHESS) {
//                if (!whitePlayer.isRobot()) {
//                    whitePlayer.play(indexX, indexY);
//                }
//            }
        }

    }

    private boolean isPointValid(int indexX, int indexY) {


        // 检查鼠标落点是否超出棋盘范围
        if (indexX < 0 || indexX >= IChessboard.CHESSBOARD_COLUMN) {
            System.out.println("index x out of bounds .");
            return false;
        }
        if (indexY < 0 || indexY >= IChessboard.CHESSBOARD_ROW) {
            System.out.println("index y out of bounds .");
            return false;
        }

        // 检查鼠标落点是否已经有棋子
        if (chessmenArray[indexX][indexY] != 0) {
            System.out.println("Chessman has been existed .");
            return false;
        }

        return true;

    }



    @Override
    public void resetChessboard(IUmpire umpire, GameStat gameStat) {
        this.umpire = umpire;
        this.gameStat = gameStat;
        this.chessmenArray = gameStat.getChessmenArray();

    }

    @Override
    public void putChessmanOnBoard(int chessX, int chessY, int chessColor) throws IndexOutOfBoundsException {

        this.lastChessX = chessX;
        this.lastChessY = chessY;

        //chessmenArray[chessX][chessY] = chessColor;

        chessboardPanel.repaint();
    }


    @Override
    public void paintComponent(Graphics graphics) {

        drawLineHorizontal(graphics);
        drawLineVertical(graphics);

        if (gameStat != null && gameStat.getSteps() > 0) {
            System.out.println(gameStat.getSteps() + "--------------------");
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




    // 悔棋
    public void retractLastStep() {

        if (gameStat.getSteps() <= 0) return;
        System.out.println("Retract");
        //chessmenArray[lastChessX][lastChessY] = 0;
        //steps--;
        //this.repaint();
    }


    // 清空棋盘
    @Override
    public void emptyChessboard() {

        lastChessX = -1;
        lastChessY = -1;

        //Arrays.fill(chessmanBorder, 7);

        for (int y = 0; y < CHESSBOARD_ROW; y++) {
            for (int x = 0; x < CHESSBOARD_COLUMN; x++) {
                chessmenArray[x][y] = 0;
            }
        }

        // 重绘棋盘
        chessboardPanel.repaint();

    }

    @Override
    public int[][] getChessmenArray() {
        return chessmenArray;
    }



    public void setUmpire(IUmpire umpire) {
        this.umpire = umpire;
    }
}
