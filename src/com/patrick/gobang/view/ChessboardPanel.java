package com.patrick.gobang.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/31 19:57
 * @Description: TODO
 */
public class ChessboardPanel extends JPanel implements InitializeComponent {

    public static final int CHESSBOARD_ROW = 15;
    public static final int CHESSBOARD_COLUMN = 15;
    public static final int CHESSBOARD_ORIGIN_X = 45;
    public static final int CHESSBOARD_ORIGIN_Y = 45;
    public static final int CHESSBOARD_SPACE = 40;


    private static ChessboardPanel chessboardPanel = new ChessboardPanel();

    public static ChessboardPanel getInstance() {
        return chessboardPanel;
    }

    private ChessboardPanel() {

        this.init();


    }

    @Override
    public void init() {

        this.setInterface();
        this.registerListener();

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
                System.out.println("----- mouse pressed -----");

                //Umpire.getInstance().judge(e.getX(), e.getY());

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

        this.drawLineHorizontal(graphics);
        this.drawLineVertical(graphics);


    }

    // 画棋盘横线，每条横线 x1 = ORIGIN_X, x2 = ORIGIN_X + 600，固定不变
    private void drawLineHorizontal(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int x1 = CHESSBOARD_ORIGIN_X;
        int x2 = CHESSBOARD_ORIGIN_X + (CHESSBOARD_COLUMN - 1) * CHESSBOARD_SPACE;

        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            int y = CHESSBOARD_ORIGIN_Y + CHESSBOARD_SPACE * i;
            graphics.drawLine(x1, y, x2, y);
        }

    }

    // 画棋盘纵线，每条纵线 y1 y2固定不变
    private void drawLineVertical(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        int y1 = CHESSBOARD_ORIGIN_Y;
        int y2 = CHESSBOARD_ORIGIN_Y + (CHESSBOARD_ROW - 1) * CHESSBOARD_SPACE;

        for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
            int x = CHESSBOARD_ORIGIN_X + CHESSBOARD_SPACE * i;
            graphics.drawLine(x, y1, x, y2);
        }

    }



}
