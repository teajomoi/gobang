package com.patrick.gobang.entity;

import com.patrick.gobang.control.GameStat;
import com.patrick.gobang.view.ChessboardPanel;

import java.util.Random;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 10:37
 * @Description: TODO
 */
public class Robot {


    private String name = null;
    private int chessColor = 0;
    private int mySteps = 0;

    private int[][] chessmanArray = null;
    private int[] chessmanBorder = null;


    public Robot(String name, int chessColor) {
        this.name = name;
        this.chessColor = chessColor;
        //this.chessmanArray = Chessboard.getChessboard().getChessmenArray();
        this.chessmanArray = GameStat.getInstance().getChessmenArray();
        //this.chessmanBorder = ChessboardPanel.getChessboard().getChessmanBorder();

        System.out.println("Robot AbstractPlayer " + name + " has been created.");
    }

    //@Override
    public void onChessmanDown(int currentPlayer) {

        if (currentPlayer == this.chessColor) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int[] aaa = chooseOnePoint();
                    //umpire666.judge(aaa[0], aaa[1]);
                    mySteps++;
                    System.out.println(name + " Observer, currentPlayer: " + currentPlayer + "  mySteps: " + mySteps);
                }
            }).start();

        }
    }


    private int[] chooseOnePoint() {
        int [] aaa = new int[2];
        while (true) {
            aaa[0] = new Random().nextInt(14);
            aaa[1] = new Random().nextInt(14);
            if (chessmanArray[aaa[0]][aaa[1]] == 0) {
                return aaa;
            }


        }

    }







}





