package com.patrick.gobang.control;


import com.patrick.gobang.entity.IChessboard;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/28 23:05
 * @Description: TODO
 */
public class GameStat {

    private static GameStat gameStat = null;

    private boolean isGameRunning = false;

    private int currentPlayer = 0;

    private int steps = 0;

    private int[][] chessmenArray = null;

    private GameStat(){
        this.isGameRunning = true;
        this.currentPlayer = IChessboard.BLACK_CHESS;
        this.steps = 0;
        this.chessmenArray = new int[IChessboard.CHESSBOARD_COLUMN][IChessboard.CHESSBOARD_ROW];
    }


    public static GameStat resetGameStat(StartGame startGame) {
        if (startGame.isCreateGameStat()) {
            gameStat = new GameStat();
        }
        return gameStat;
    }


    public static GameStat getInstance() {
        return gameStat;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        this.currentPlayer *= -1;
    }

    public int getSteps() {
        return steps;
    }

    public void increaseStep() {
        this.steps++;
    }

    public int[][] getChessmenArray() {
        return chessmenArray;
    }

    public void insertChessman(int x, int y, int chessColor) {
        this.chessmenArray[x][y] = chessColor;
    }

}
