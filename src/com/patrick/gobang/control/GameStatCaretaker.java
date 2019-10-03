package com.patrick.gobang.control;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: PatrickZ
 * @Date: 2019/10/2 20:11
 * @Description: TODO
 */
public class GameStatCaretaker {


    private HashMap<Integer, GameStat> gameStatMap;


    public GameStatCaretaker() {
        this.gameStatMap = new HashMap<>(2 << 8);
    }

    public GameStat getGameStat(int idx) {
        return gameStatMap.get(idx);
    }

    public void setGameStat(int idx, GameStat gameStat) {
        this.gameStatMap.put(idx, gameStat);
        Set<Integer> set = gameStatMap.keySet();
        for (int i : set) {
            System.out.println("key: " + i + "  ");
        }
        System.out.println();
    }

    public int getSize() {
        return gameStatMap.size();
    }


}
