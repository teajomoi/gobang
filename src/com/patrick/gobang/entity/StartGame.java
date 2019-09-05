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

    public StartGame() {

        this.restartGame();

    }


    private void restartGame() {

        ChessboardPanel.getChessboard().emptyChessboard();

        umpire = Umpire.getInstance();

        umpire.resetCurrentPlayer();
        umpire.setGameRunning(true);
        createNewPlayer();

        umpire.notifyObservers(Chessboard.BLACK_CHESS);


        ButtonPanel.getInstance().msgLabel.setText("游戏进行中...");
        System.out.println("start game");

    }


    private void createNewPlayer() {


        // 清空观察者list
        umpire.clearObservers();

        // human = new Human();
        Robot blackRobot = new Robot(umpire, "Black Robot", Chessboard.BLACK_CHESS);
        Robot whiteRobot = new Robot(umpire, "White Robot", Chessboard.WHITE_CHESS);

        umpire.attach(blackRobot);
        umpire.attach(whiteRobot);


    }


}
