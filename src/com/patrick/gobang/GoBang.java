package com.patrick.gobang;

import com.patrick.gobang.view.MainFrame;

import javax.swing.*;

/**
 * @Author: PatrickZ
 * @Date: 2019/8/28 00:44
 * @Description: TODO
 */
public class GoBang {

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });



    }


}
