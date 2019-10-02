package com.patrick.gobang.control;

/**
 * @Author: PatrickZ
 * @Date: 2019/10/2 11:22
 * @Description: TODO
 */
public class Mediator extends AbstractMediator {



    @Override
    public void execute(int command, Object... objects) {
        if (command == CHECK_MOUSE_POINT) {
            super.checkMousePoint((double)objects[0], (double)objects[1]);
        }
    }








}
