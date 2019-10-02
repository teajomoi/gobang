package com.patrick.gobang.control;

import com.patrick.gobang.entity.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/10/2 10:45
 * @Description: TODO
 */
public abstract class AbstractMediator {

    protected IUmpire umpire;

    protected IChessboard chessboard;

    protected GameStat gameStat;

    protected AbstractPlayer blackPlayer;

    protected AbstractPlayer whitePlayer;

    protected int[][] chessmenArray;


    public final int CHECK_MOUSE_POINT = 1;




    public AbstractMediator() {

        //umpire = new Umpire();
        gameStat = GameStat.getInstance();
        chessmenArray = gameStat.getChessmenArray();

        chessboard = Chessboard.getChessboard();
        chessboard.setMediator(this);

        blackPlayer = new HumanPlayer((Umpire) umpire, chessboard.BLACK_CHESS);
        whitePlayer = new HumanPlayer((Umpire) umpire, chessboard.WHITE_CHESS);


    }

    public abstract void execute(int command, Object... objects);


    protected void checkMousePoint(double mouseX, double mouseY) throws NullPointerException {

        System.out.println("------------- mouse pressed ---------------");

        if (gameStat == null || !gameStat.isGameRunning()) {
            System.out.println("Game is not running.");
            return;
        }

        double cellX = (mouseX - IChessboard.CHESSBOARD_ORIGIN_X) / IChessboard.CHESSBOARD_SPACE;
        double cellY = (mouseY - IChessboard.CHESSBOARD_ORIGIN_Y) / IChessboard.CHESSBOARD_SPACE;

        int indexX = (int) Math.round(cellX);
        int indexY = (int) Math.round(cellY);


        if (isPointValid(indexX, indexY)) {

            int currentPlayer = gameStat.getCurrentPlayer();

            if (currentPlayer == IChessboard.BLACK_CHESS) {
                if (!blackPlayer.isRobot()) {
                    blackPlayer.play(indexX, indexY);
                }
            } else if (currentPlayer == IChessboard.WHITE_CHESS) {
                if (!whitePlayer.isRobot()) {
                    whitePlayer.play(indexX, indexY);
                }
            }
        }

    }


    private boolean isPointValid(int indexX, int indexY) {


        // 检查鼠标落点是否超出棋盘范围
        if (indexX < 0 || indexX >= IChessboard.CHESSBOARD_COLUMN) {
            System.out.println("index x out of bounds .");
            return false;
        }
        if (indexY < 0 || indexY >= IChessboard.CHESSBOARD_ROW) {
            System.out.println("index y out of bounds .");
            return false;
        }

        // 检查鼠标落点是否已经有棋子
        if (chessmenArray[indexX][indexY] != 0) {
            System.out.println("Chessman has been existed .");
            return false;
        }


        return true;

    }


}
