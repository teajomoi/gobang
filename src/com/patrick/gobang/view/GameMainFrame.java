package com.patrick.gobang.view;

import com.patrick.gobang.listener.ChessMouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/28 01:02
 * @Description: TODO
 */
public class GameMainFrame extends JFrame {

    private JPanel chessPanel = null;
    private JPanel buttonPanel = null;


    public GameMainFrame() {

        init();

        chessPanel.addMouseListener(new ChessMouseListener());

    }


    private void init() {

        initChessPanel();
        initButtonPanel();

        initGameFrame();
    }

    private void initGameFrame() {

        this.setLayout(new BorderLayout());

        this.getContentPane().add(chessPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);

        this.setSize(800, 670);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setVisible(true);
    }


    private void initButtonPanel() {

        buttonPanel = new JPanel(new GridLayout(7, 1, 0, 33));
        buttonPanel.setPreferredSize(new Dimension(150, 0));
        buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "快捷功能区"));

        JButton startButton = new JButton("开始新游戏");
        JButton retractButton = new JButton("悔棋");
        JButton surrenderButton = new JButton("投降");

        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(startButton);
        buttonPanel.add(retractButton);
        buttonPanel.add(surrenderButton);

    }

    private void initChessPanel() {

        chessPanel = new ChessPanel();

        chessPanel.setBackground(Color.LIGHT_GRAY);
        chessPanel.setPreferredSize(new Dimension(600, 0));
        chessPanel.setBorder(BorderFactory.createLoweredBevelBorder());

    }

//    @Override
//    public void paint(Graphics graphics) {
//
//        super.paint(graphics);
//
//        DrawChess.drawLineHorizontal(graphics);
//        DrawChess.drawLineVertical(graphics);
//
//
//        graphics.fill3DRect(0, 0, 35, 20, true);
//
//    }


}
