package com.patrick.gobang.entity;


public interface IUmpire {


    void judge(int x, int y);

    void switchPlayer();

    void selectPlayer(int x, int y);

    void retract();


}
