package com.patrick.gobang.entity;

import com.patrick.gobang.view.ChessboardPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:16
 * @Description: 裁判类: 被观察者，饿汉式单例模式
 */
public class Umpire {

    private int chessmanX = -1;
    private int chessmanY = -1;

    private List<ChessObserver> chessObserverList = null;
    private int player = 1;

    private ChessboardPanel chessboardPanel = ChessboardPanel.getInstance();
    private ChessBoard chessBoard = ChessBoard.getInstance();
    private int[][] chessmenArray = chessBoard.getChessmenArray();


    private static Umpire umpire = new Umpire();


    private Umpire() {
        chessObserverList = new ArrayList<>();
    }

    public static Umpire getInstance() {
        return umpire;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
        this.notifyObservers(player);
    }


    public void attach(ChessObserver chessObserver) {
        chessObserverList.add(chessObserver);
    }

    public void detach(ChessObserver chessObserver) {
        chessObserverList.remove(chessObserver);
    }


    public void notifyObservers(int player) {
        for (ChessObserver chessObserver : chessObserverList) {
            chessObserver.onChessDown(player);
        }
    }






    public void judge(double mouseX, double mouseY) {

        // 检查鼠标落点是否有效
        if (checkMousePoint(mouseX, mouseY)) {

            // 给棋盘数组插入棋子坐标及颜色
            chessBoard.insertChessman(chessmanX, chessmanY, player);

            setPlayer(player);

            // 给棋盘绘制棋子
            chessboardPanel.fillChessman(chessmanX, chessmanY, player);


            // 交换棋手
            player *= -1;


            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 15; i++) {
                    System.out.print(chessmenArray[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }


    }



    private boolean checkMousePoint(double x, double y) {

        double cellX = (x - ChessboardPanel.CHESSBOARD_ORIGIN_X) / ChessboardPanel.CHESSBOARD_SPACE;
        double cellY = (y - ChessboardPanel.CHESSBOARD_ORIGIN_Y) / ChessboardPanel.CHESSBOARD_SPACE;

        chessmanX = (int) Math.round(cellX);
        chessmanY = (int) Math.round(cellY);

        // 检查鼠标落点是否超出棋盘范围
        if (chessmanX < 0 || chessmanX >= ChessboardPanel.CHESSBOARD_COLUMN) { return false; }
        if (chessmanY < 0 || chessmanY >= ChessboardPanel.CHESSBOARD_ROW) { return false; }

        // 检查鼠标落点是否已经有棋子
        return chessmenArray[chessmanX][chessmanY] == 0;


    }




}
