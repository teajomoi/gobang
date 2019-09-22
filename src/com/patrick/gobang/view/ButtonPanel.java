package com.patrick.gobang.view;

import com.patrick.gobang.control.NewGame;
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


    public JLabel msgLabel = null;
    private JButton startButton = null;
    private JButton retractButton = null;
    private JButton surrenderButton = null;

    private static ButtonPanel buttonPanel = new ButtonPanel();

    private ButtonPanel() {

        this.init();
    }

    public static ButtonPanel getInstance() {
        return buttonPanel;
    }


    @Override
    public void setInterface() {

        this.setLayout(new GridLayout(7, 1, 0, 33));
        this.setPreferredSize(new Dimension(150, 0));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "快捷功能区"));

    }


    @Override
    public void addChildrenComponent() {

        msgLabel = new JLabel("游戏暂未开始");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("fsagf");
        comboBox.addItem("aaa");
        startButton = new JButton("开始新游戏");
        retractButton = new JButton("悔棋");
        surrenderButton = new JButton("投降");

        JTextField textField = new JTextField();
        textField.setEditable(false);

        this.add(msgLabel);
        //this.add(new JLabel());
        this.add(comboBox);
        this.add(startButton);
        this.add(retractButton);
        this.add(surrenderButton);
        this.add(textField);

    }

    @Override
    public void registerListener() {

        //startButton.addActionListener(e -> new StartGame());

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame();
            }
        });

        retractButton.addActionListener(e -> ChessboardPanel.getChessboard().retractLastStep());

        //surrenderButton.addActionListener(e -> Umpire.getInstance().setGameRunning(false));
        surrenderButton.addActionListener(e -> {
            Umpire.getInstance().setGameRunning(false);
            msgLabel.setText("游戏结束");
        });

    }


}
