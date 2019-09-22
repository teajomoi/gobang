package com.patrick.gobang.control;

import com.patrick.gobang.entity.BlackPlayer;
import com.patrick.gobang.entity.IChessboard;
import com.patrick.gobang.entity.Umpire2;
import com.patrick.gobang.entity.WhitePlayer;
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

        ChessboardPanel.getChessboard().emptyChessboard();
        this.resetGameStatus();
        this.resetChessboardFacade();

    }


    private void resetGameStatus() {

        GameStatus.isGameRunning = true;
        GameStatus.currentPlayer = IChessboard.BLACK_CHESS;
        GameStatus.steps = 0;

    }


    private void resetChessboardFacade() {

        ChessboardFacade chessboardFacade = ChessboardFacade.getInstance();

        Umpire2 umpire2 = new Umpire2();

        chessboardFacade.setBlackPlayer(new BlackPlayer(umpire2, false));
        chessboardFacade.setWhitePlayer(new WhitePlayer(umpire2, false));


    }

}
