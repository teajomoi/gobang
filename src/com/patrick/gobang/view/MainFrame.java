package com.patrick.gobang.view;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 08:47
 * @Description: TODO
 */
public class MainFrame extends JFrame implements InitializeComponent {



    public MainFrame() {

        init();

    }


    @Override
    public void init() {

        this.setInterface();
        this.addChildrenComponent();

    }


    @Override
    public void setInterface() {

        this.setLayout(new BorderLayout());

        this.setSize(800, 670);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }


    @Override
    public void addChildrenComponent() {

        // JPanel chessboardPanel = ChessboardPanel.getInstance();
        JPanel chessboardPanel = new ChessboardPanel();
        JPanel buttonPanel = ButtonPanel.getInstance();

        this.getContentPane().add(chessboardPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);


    }



    @Override
    public void registerListener() {

    }



}
