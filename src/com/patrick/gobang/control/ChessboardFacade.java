package com.patrick.gobang.control;

import com.patrick.gobang.entity.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/22 16:41
 * @Description: TODO
 */
public class ChessboardFacade {


    //private IChessboard chessboard = Chessboard.getChessboard();
    //private int[][] chessmenArray = chessboard.getChessmenArray();

    private GameStat gameStat = null;
    private int[][] chessmenArray = null;

    private IUmpire umpire = null;
    private AbstractPlayer blackPlayer = null;
    private AbstractPlayer whitePlayer = null;


    //private static ChessboardFacade chessboardFacade = new ChessboardFacade();

    private ChessboardFacade(){
        //gameStat = GameStat.getInstance();
        //chessmenArray = gameStat.getChessmenArray();
    }

    //public static ChessboardFacade getInstance() {
     //   return chessboardFacade;
    //}


    public void mousePressed(double mouseX, double mouseY) throws NullPointerException {

//        System.out.println("------------- mouse pressed ---------------");
//
//        if (gameStat == null) {
//            System.out.println("Game is not running.");
//            return;
//        }
//
//        double cellX = (mouseX - IChessboard.CHESSBOARD_ORIGIN_X) / IChessboard.CHESSBOARD_SPACE;
//        double cellY = (mouseY - IChessboard.CHESSBOARD_ORIGIN_Y) / IChessboard.CHESSBOARD_SPACE;
//
//        int indexX = (int) Math.round(cellX);
//        int indexY = (int) Math.round(cellY);


//        if (isPointValid(indexX, indexY)) {
//
//            int currentPlayer = gameStat.getCurrentPlayer();
//
//            if (currentPlayer == IChessboard.BLACK_CHESS) {
//                if (!blackPlayer.isRobot()) {
//                    blackPlayer.play(indexX, indexY);
//                }
//            } else if (currentPlayer == IChessboard.WHITE_CHESS) {
//                if (!whitePlayer.isRobot()) {
//                    whitePlayer.play(indexX, indexY);
//                }
//            }
//        }

    }


//    private boolean isPointValid(int indexX, int indexY) {
//
//
//        // 检查鼠标落点是否超出棋盘范围
//        if (indexX < 0 || indexX >= IChessboard.CHESSBOARD_COLUMN) {
//            System.out.println("index x out of bounds .");
//            return false;
//        }
//        if (indexY < 0 || indexY >= IChessboard.CHESSBOARD_ROW) {
//            System.out.println("index y out of bounds .");
//            return false;
//        }
//
//        // 检查鼠标落点是否已经有棋子
//        if (chessmenArray[indexX][indexY] != 0) {
//            System.out.println("Chessman has been existed .");
//            return false;
//        }
//
//
//        return true;
//
//    }



    public void setBlackPlayer(AbstractPlayer blackPlayer) {
        blackPlayer = blackPlayer;
    }


    public void setWhitePlayer(AbstractPlayer whitePlayer) {
        whitePlayer = whitePlayer;
    }

//    public void setUmpire(Umpire umpire) {
//        umpire = umpire;
//    }
}
