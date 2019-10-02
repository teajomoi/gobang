package com.patrick.gobang.control;

import com.patrick.gobang.entity.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/22 18:29
 * @Description: TODO
 */
public class NewGame {

    private IChessboard chessboard;
    private Umpire umpire;

    private GameStat gameStat = null;
    private boolean isCreateGameStat = false;




    public NewGame() {

        //this.restartGame();

    }


    private void restartGame() {

        //if (GameStatus.isGameRunning) return;

        //if (gameStat != null && gameStat.isGameRunning()) return;

        //this.resetGameStat();

        //this.emptyChessboard();
        //this.resetChessboard();


        //this.resetGameStatus();

        //this.resetChessboardFacade();
        //this.notifyObservers();

        //System.out.println("Restart Game...");

    }

    private void resetChessboard() {
        //Chessboard.getChessboard().resetChessboard(gameStat);
    }


    private void resetGameStat() {
        //this.isCreateGameStat = true;
        //this.gameStat = GameStat.resetGameStat(this);
        //this.isCreateGameStat = false;
    }


    private void emptyChessboard() {

        //Chessboard.getChessboard().emptyChessboard();
    }


    private void resetGameStatus() {

        //GameStatus.isGameRunning = true;
        //GameStatus.currentPlayer = IChessboard.BLACK_CHESS;
        //GameStatus.steps = 0;

    }


    private void resetChessboardFacade() {

        //umpire = new Umpire();
        //AbstractPlayer blackPlayer = new RobotPlayer(umpire, IChessboard.BLACK_CHESS);
//        AbstractPlayer blackPlayer = new HumanPlayer(umpire, IChessboard.BLACK_CHESS);
//        AbstractPlayer whitePlayer = new HumanPlayer(umpire, IChessboard.WHITE_CHESS);
//        //AbstractPlayer whitePlayer = new RobotPlayer(umpire, IChessboard.WHITE_CHESS);
//        System.out.println("observers: " + umpire.countObservers());
//
//        ChessboardFacade facade = ChessboardFacade.getInstance();
//        facade.setUmpire(umpire);
//        facade.setBlackPlayer(blackPlayer);
//        facade.setWhitePlayer(whitePlayer);


    }

    private void notifyObservers() {
        //umpire.setObservableChanged();
        //umpire.notifyObservers(gameStat.getCurrentPlayer());
    }


//    public boolean isCreateGameStat() {
//        //return isCreateGameStat;
//    }
}
