package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessboardPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:16
 * @Description: 裁判类: 被观察者，饿汉式单例模式
 */
public class Umpire {

    private boolean isGameRunning = false;

    private int currentPlayer = Chessboard.BLACK_CHESS;

    private int chessmanX = -1;
    private int chessmanY = -1;

    private List<ChessObserver> chessObserverList = null;

    private Chessboard chessboard = null;
    private int[][] chessmenArray =  null;


    private static Umpire umpire = new Umpire();


    private Umpire() {

        chessObserverList = new ArrayList<>();
        chessboard = ChessboardPanel.getChessboard();
        chessmenArray = chessboard.getChessmenArray();

    }

    public static Umpire getInstance() {
        return umpire;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }


    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void resetCurrentPlayer() {
        this.currentPlayer = 1;
    }

    private void switchPlayer() {
        currentPlayer *= -1;
        //this.notifyObservers(chessmanX, chessmanY, currentPlayer);
        this.notifyObservers(currentPlayer);

    }


    public void attach(ChessObserver chessObserver) {

        if (chessObserver == null) throw new NullPointerException();

        if (! chessObserverList.contains(chessObserver)) {
            chessObserverList.add(chessObserver);
            System.out.println(chessObserverList.size());
        }
    }


    public void clearObservers() {
        chessObserverList.clear();
    }

    public void detach(ChessObserver chessObserver) {
        chessObserverList.remove(chessObserver);
    }


    public void notifyObservers(int chessColor) {
        for (ChessObserver chessObserver : chessObserverList) {
            chessObserver.onChessmanDown(chessColor);
        }
    }



    public boolean checkMousePoint(double mouseX, double mouseY) {

        // 检查游戏是否启动
        if (! isGameRunning) {
            System.out.println("Game is not running!");
            return false;
        }

        double cellX = (mouseX - Chessboard.CHESSBOARD_ORIGIN_X) / Chessboard.CHESSBOARD_SPACE;
        double cellY = (mouseY - Chessboard.CHESSBOARD_ORIGIN_Y) / Chessboard.CHESSBOARD_SPACE;

        int indexX = (int) Math.round(cellX);
        int indexY = (int) Math.round(cellY);

        // 检查鼠标落点是否超出棋盘范围
        if (indexX < 0 || indexX >= Chessboard.CHESSBOARD_COLUMN) {
            System.out.println("index x out of bounds .");
            return false;
        }
        if (indexY < 0 || indexY >= Chessboard.CHESSBOARD_ROW) {
            System.out.println("index y out of bounds .");
            return false;
        }

        // 检查鼠标落点是否已经有棋子
        if (chessmenArray[indexX][indexY] != 0) {
            System.out.println("Chessman has been existed .");
            return false;
        }

        this.judge(indexX, indexY);

        return true;


    }

    public void judge(int indexX, int indexY) {

        this.chessmanX = indexX;
        this.chessmanY = indexY;

        chessboard.putChessmanOnBoard(chessmanX, chessmanY, currentPlayer);

        if (isWinning()) {
            isGameRunning = false;
            System.out.println(currentPlayer + " win");

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, currentPlayer + " winning!",
                            "fsagasdg", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            return;


        }

        // 交换棋手
        this.switchPlayer();
        // currentPlayer *= -1;

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 15; i++) {
                System.out.print(chessmenArray[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();



    }



    private boolean isWinning() {

        if (checkWestToEast()) return true;
        if (checkNorthToSouth()) return true;
        if (checkNorthwestToSoutheast()) return true;
        if (checkSouthwestToNortheast()) return true;

        return false;
    }

    private boolean checkSouthwestToNortheast() {

        int continuous = 0;
        int x, y, xMaximum;
        // 棋子落点在左上三角形区域。
        if (chessmanX + chessmanY <= chessmenArray.length - 1) {
            x = 0;
            y = chessmanX + chessmanY;
            xMaximum = chessmanX + chessmanY;
        } else {  // 棋子落点在右下三角形区域
            x = chessmanX - (chessmenArray[chessmanY].length - 1 - chessmanY);
            y = chessmenArray[chessmanY].length - 1;
            xMaximum = chessmenArray.length;
        }

        while (x < xMaximum) {
            if (chessmenArray[x][y] == currentPlayer) {
                continuous++;
                //System.out.println("SW --> NE: " + continuous);
                if (continuous >= 5) {
                    return true;
                }
            } else {
                continuous = 0;
            }
            x++;
            y--;
        }

        return false;
    }

    private boolean checkNorthwestToSoutheast() {

        int continuous = 0;
        int x, y, xMaximum;
        if (chessmanY >= chessmanX) {
            x = 0;
            y = chessmanY - chessmanX;
            xMaximum = chessmanX + (chessmenArray[x].length - chessmanY);

        } else {
            x = chessmanX - chessmanY;
            y = 0;
            xMaximum = chessmenArray.length;
        }

        // System.out.println(x + "...." + y + "...." + xMaximum);
        while (x < xMaximum) {
            if (chessmenArray[x][y] == currentPlayer) {
                continuous++;
                //System.out.println("NW -- SE: " + continuous);
                if (continuous >= 5) {
                    return true;
                }
            } else {
                continuous = 0;
            }

            x++;
            y++;
        }


        return false;
    }

    private boolean checkWestToEast() {
        int continuous = 0;

        // 固定 Y坐标 chessmanY，遍历X坐标，求水平线是否五子相连。
        for (int x = 0; x < chessmenArray.length; x++) {
            if (chessmenArray[x][chessmanY] == currentPlayer) {
                continuous++;
                // System.out.println("horizontal: " + continuous);
                if (continuous >= 5) {
                    return true;
                }

            } else {
                continuous = 0;
            }
        }
        return false;
    }

    private boolean checkNorthToSouth() {
        int continuous = 0;

        // 固定 X坐标chessmanX，遍历Y坐标，求垂直线是否五子相连。
        for (int y = 0; y < chessmenArray[chessmanX].length; y++) {
            if (chessmenArray[chessmanX][y] == currentPlayer) {
                continuous++;
                // System.out.println("vertical: " + continuous);
                if (continuous >= 5) {
                    return true;
                }
            } else {
                continuous = 0;
            }
        }
        return false;
    }




}
