package com.patrick.gobang.entity;

import com.patrick.gobang.control.GameStat;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/22 18:49
 * @Description: TODO
 */
public class Umpire extends Observable implements IUmpire {

    private IChessboard chessboard = null;
    private int[][] chessmenArray =  null;
    private GameStat gameStat = null;

    private int currentPlayer;

    private AbstractPlayer blackPlayer;
    private AbstractPlayer whitePlayer;

    private int chessmanX = -1;
    private int chessmanY = -1;

    public Umpire(GameStat gameStat) {

        this.chessboard = Chessboard.getChessboard();

        this.gameStat = gameStat;
        this.chessmenArray = gameStat.getChessmenArray();
        this.currentPlayer = gameStat.getCurrentPlayer();

    }


    @Override
    public void judge(int x, int y) {

        this.chessmanX = x;
        this.chessmanY = y;

        this.putChessmanOnBoard();

        if (isWinning()) {
            this.finishGame();
        } else {
            this.switchPlayer();
        }

    }


    @Override
    public void selectPlayer(int x, int y) {
        if (currentPlayer == IChessboard.BLACK_CHESS) {
            if (!blackPlayer.isRobot()) {
                blackPlayer.play(x, y);
            }
        } else if (currentPlayer == IChessboard.WHITE_CHESS) {
            if (!whitePlayer.isRobot()) {
                whitePlayer.play(x, y);
            }
        }

    }


    @Override
    public void switchPlayer() {

        gameStat.switchPlayer();

        this.notifyObservers(gameStat.getCurrentPlayer());

        //System.out.println("notifyObservers, Current Player: " + gameStat.getCurrentPlayer());

    }


    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    private void putChessmanOnBoard() {

        gameStat.increaseStep();
        System.out.println("GameStat Steps: " + gameStat.getSteps());

        gameStat.insertChessman(chessmanX, chessmanY, gameStat.getCurrentPlayer());
        chessboard.repaintChessboard(chessmanX, chessmanY);

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 15; i++) {
                System.out.print(chessmenArray[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void finishGame() {

        gameStat.setGameRunning(false);
        System.out.println(gameStat.getCurrentPlayer() + " win");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, gameStat.getCurrentPlayer() + " winning!",
                        "Finish Game", JOptionPane.INFORMATION_MESSAGE);
            }
        });

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
            if (chessmenArray[x][y] == this.currentPlayer) {
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
            if (chessmenArray[x][y] == this.currentPlayer) {
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
            if (chessmenArray[x][chessmanY] == this.currentPlayer) {
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
            if (chessmenArray[chessmanX][y] == this.currentPlayer) {
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


    public void setBlackPlayer(AbstractPlayer blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public void setWhitePlayer(AbstractPlayer whitePlayer) {
        this.whitePlayer = whitePlayer;
    }
}
