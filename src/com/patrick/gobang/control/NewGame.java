package com.patrick.gobang.control;

import com.patrick.gobang.entity.*;
import com.patrick.gobang.view.ChessboardPanel;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/22 18:29
 * @Description: TODO
 */
public class NewGame {


    public NewGame() {

        System.out.println("Restart Game...");
        this.restartGame();

    }


    private void restartGame() {

        this.emptyChessboard();
        this.resetGameStatus();

        this.resetChessboardFacade();

    }


    private void emptyChessboard() {

        ChessboardPanel.getChessboard().emptyChessboard();
    }


    private void resetGameStatus() {

        GameStatus.isGameRunning = true;
        GameStatus.currentPlayer = IChessboard.BLACK_CHESS;
        GameStatus.steps = 0;

    }


    private void resetChessboardFacade() {

        Umpire umpire = new Umpire();
        AbstractPlayer blackPlayer = new HumanPlayer(umpire, IChessboard.BLACK_CHESS, false);
        AbstractPlayer whitePlayer = new HumanPlayer(umpire, IChessboard.WHITE_CHESS, false);

        System.out.println("observers: " + umpire.countObservers());

        ChessboardFacade facade = ChessboardFacade.getInstance();
        facade.setUmpire(umpire);
        facade.setBlackPlayer(blackPlayer);
        facade.setWhitePlayer(whitePlayer);


    }



}
