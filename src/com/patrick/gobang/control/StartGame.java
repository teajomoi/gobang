package com.patrick.gobang.control;

import com.patrick.gobang.entity.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/10/2 16:02
 * @Description: TODO
 */
public class StartGame {

    private Umpire umpire;
    private GameStat gameStat = null;
    private boolean isCreateGameStat = false;


    public StartGame() {
        this.restartGame();
        System.out.println("Restart Game...");
    }

    public boolean isCreateGameStat() {
        return isCreateGameStat;
    }

    private void restartGame() {

        this.resetGameStat();
        this.resetActor();
        this.resetChessboard();

    }


    private void resetActor() {

        this.umpire = new Umpire(gameStat);

        GameStatCaretaker caretaker = new GameStatCaretaker();

        //AbstractPlayer blackPlayer = new RobotPlayer(umpire, IChessboard.BLACK_CHESS);
        AbstractPlayer blackPlayer = new HumanPlayer(umpire, IChessboard.BLACK_CHESS);
        AbstractPlayer whitePlayer = new HumanPlayer(umpire, IChessboard.WHITE_CHESS);
        //AbstractPlayer whitePlayer = new RobotPlayer(umpire, IChessboard.WHITE_CHESS);

        umpire.setBlackPlayer(blackPlayer);
        umpire.setWhitePlayer(whitePlayer);
        umpire.setCaretaker(caretaker);


        System.out.println("observers: " + umpire.countObservers());

    }


    private void resetGameStat() {
        this.isCreateGameStat = true;
        this.gameStat = GameStat.resetGameStat(this);
        this.isCreateGameStat = false;
    }


    private void resetChessboard() {
        Chessboard.getChessboard().resetChessboard(umpire, gameStat);
    }






}
