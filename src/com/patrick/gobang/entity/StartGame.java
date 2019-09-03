package com.patrick.gobang.entity;

import com.patrick.gobang.view.ButtonPanel;
import com.patrick.gobang.view.ChessboardPanel;


/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 15:31
 * @Description: TODO
 */
public class StartGame {


    private Umpire umpire = null;
    private Chessboard chessboard = null;
    private WhiteChess whiteChess = null;
    private BlackChess blackChess = null;

    public StartGame() {


        this.restartGame();
        System.out.println("start game");

    }


    private void restartGame() {

        this.attachObservers();

        chessboard.emptyChess();

        umpire.resetChessColor();
        umpire.setGameRunning(true);


        ButtonPanel.getInstance().msgLabel.setText("游戏进行中...");

    }


    private void attachObservers() {


        umpire = Umpire.getInstance();
        // 清空观察者list
        umpire.clearObservers();

        chessboard = ChessboardPanel.getChessboard();
        whiteChess = new WhiteChess();
        blackChess = new BlackChess();

        //umpire.attach(chessboard);
        umpire.attach(whiteChess);
        umpire.attach(blackChess);


        //umpire.attach(whiteChess);
        //umpire.attach(blackChess);

    }


}
