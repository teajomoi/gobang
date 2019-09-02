package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessboardPanel;


/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 15:31
 * @Description: TODO
 */
public class StartGame {


    private Umpire umpire = null;
    private ChessBoard chessBoard = null;
    private WhiteChess whiteChess = null;
    private BlackChess blackChess = null;

    public StartGame() {


        this.restartGame();
        System.out.println("start game");

    }


    private void restartGame() {

        this.attachObservers();
        chessBoard.emptyChess();
        umpire.resetChessColor();
        umpire.setGameRunning(true);

        ChessboardPanel.getInstance().repaint();

    }


    private void attachObservers() {


        umpire = Umpire.getInstance();
        // 清空观察者list
        umpire.clearObservers();

        chessBoard = ChessBoard.getInstance();
        whiteChess = new WhiteChess();
        blackChess = new BlackChess();

        umpire.attach(chessBoard);
        umpire.attach(whiteChess);
        umpire.attach(blackChess);


        //umpire.attach(whiteChess);
        //umpire.attach(blackChess);

    }


}
