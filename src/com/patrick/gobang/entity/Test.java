package com.patrick.gobang.entity;

/**
 * @Author: PatrickZ
 * @Date: 2019/9/4 22:42
 * @Description: TODO
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Test extends JFrame {

//    private static final long serialVersionUID = 1L;
//    private static final String STR = "Completed : ";
//    private JProgressBar progressBar = new JProgressBar();
//    private JTextField text = new JTextField(10);
//    private JButton start = new JButton("Start");
//    private JButton end = new JButton("End");
//    private boolean flag = false;
//    private int count = 0;
//
//    public Test() {
//        this.setLayout(new FlowLayout());
//        add(progressBar);
//        text.setEditable(false);
//        add(text);
//        add(start);
//        add(end);
//        start.addActionListener(new Start());
//        end.addActionListener(new End());
//    }
//
//    private void go() {
//        while (count < 100) {
//            try {
//                Thread.sleep(100);//这里比作要完成的某个耗时的工作
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //更新进度条和输入框
//            if (flag) {
//                count++;
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressBar.setValue(count);
//                        text.setText(STR + String.valueOf(count) + "%");
//                    }
//                });
//
//            }
//        }
//    }
//    private class Start implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            flag = true;//设置开始更新的标志
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    go();
//                }
//            }).start();
//
//        }
//    }
//    private class End implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            flag = false;//停止
//            count = 0;
//        }
//    }


    public static void main(String[] args) {

//        Test fg = new Test();
//        fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fg.setSize(300, 100);
//        fg.setVisible(true);
        int aaa = 10;
        int bbb = aaa;
        System.out.println(bbb);
        aaa = 5;
        System.out.println(bbb);


    }
}
