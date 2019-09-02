package com.patrick.gobang.view;

import com.patrick.gobang.entity.StartGame;
import com.patrick.gobang.entity.Umpire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.registerListener();

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

        JTextField textField = new JTextField();
        textField.setEditable(false);

        this.add(new JLabel("fsggsag"));
        this.add(new JLabel());
        this.add(startButton);
        this.add(retractButton);
        this.add(surrenderButton);
        this.add(textField);

    }

    @Override
    public void registerListener() {

        startButton.addActionListener(e -> new StartGame());

        surrenderButton.addActionListener(e -> Umpire.getInstance().setGameRunning(false));

    }

    private class RestartGame {

        private RestartGame() {
            System.out.println("start new game....");
        }

    }


}
