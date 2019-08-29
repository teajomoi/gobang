package com.patrick.gobang.listener;

import com.patrick.gobang.entity.Umpire;
import com.patrick.gobang.view.ChessPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/28 21:34
 * @Description: TODO
 */
public class ChessMouseListener implements MouseListener {

    private ChessPanel chessPanel = null;
    private Umpire umpire = Umpire.getInstance();


    public ChessMouseListener(JPanel jPanel) {
        this.chessPanel = (ChessPanel) jPanel;

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        double mouseX = e.getX();
        double mouseY = e.getY();

        umpire.judge(mouseX, mouseY, chessPanel);


    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
