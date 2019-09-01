package com.patrick.gobang.view;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/1 09:10
 * @Description: TODO
 */
public class ButtonPanel extends JPanel implements InitializeComponent {


    private JButton startButton = null;
    private JButton retractButton = null;
    private JButton surrenderButton = null;


    public ButtonPanel() {

        this.init();

    }


    @Override
    public void init() {

        this.addChildrenComponent();
        this.setInterface();

    }


    @Override
    public void setInterface() {

        this.setLayout(new GridLayout(7, 1, 0, 33));
        this.setPreferredSize(new Dimension(150, 0));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "快捷功能区"));

    }


    @Override
    public void addChildrenComponent() {

        startButton = new JButton("开始新游戏");
        retractButton = new JButton("悔棋");
        surrenderButton = new JButton("投降");

        this.add(new JLabel());
        this.add(new JLabel());
        this.add(startButton);
        this.add(retractButton);
        this.add(surrenderButton);

    }

    @Override
    public void registerListener() {


    }


}
