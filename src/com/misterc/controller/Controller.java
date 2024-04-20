package com.misterc.controller;

import com.misterc.input.Mister;

public abstract class Controller {

    protected final MisterC currentProgram;
    protected final Controller previousController;

    public Controller(MisterC program, Controller previousController) {
        this.currentProgram = program;
        this.previousController = previousController;
    }

    public abstract void handle(String input);

    public abstract void paint();

}
