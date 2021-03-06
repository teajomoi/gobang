package com.patrick.gobang.view;

import com.patrick.gobang.entity.Chessboard;
import com.patrick.gobang.entity.IChessboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/31 19:57
 * @Description: TODO
 */
public final class ChessboardPanel extends JPanel implements InitializeComponent {

    private IChessboard chessboard = null;
    private boolean isCreateChessboard = false;

    ChessboardPanel() {

        this.init();
        this.createChessboard();
    }


    private void createChessboard() {
        this.isCreateChessboard = true;
        this.chessboard = Chessboard.createChessboard(this);
        this.isCreateChessboard = false;

    }


    public boolean isCreateChessboard() {
        return isCreateChessboard;
    }



    @Override
    public void setInterface() {

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLoweredBevelBorder());
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(600, 600));

    }

    @Override
    public void registerListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                chessboard.mousePressed(e.getX(), e.getY());

//                Object object = e.getSource();
//                if (object instanceof ChessPanel) {
//                    System.out.println(object.toString());
//                    ChessPanel chessPanel = (ChessPanel) object;
//                }
            }


        });
    }


    @Override
    public void addChildrenComponent() {

    }



    // 绘制整个棋盘
    @Override
    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        chessboard.paintComponent(graphics);

    }



}
