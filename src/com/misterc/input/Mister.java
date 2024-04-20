package com.misterc.input;

import com.misterc.controller.MisterC;

public class Mister extends MisterC {

    public Mister() {

    }

    @Override
    public Mister getProgram() {
        return this;
    }

    public void kill() {
        System.out.println("kill");
    }

}
