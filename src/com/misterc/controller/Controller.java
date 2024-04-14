package com.misterc.controller;

public abstract class Controller {

    protected final MisterC currentProgram;
    protected final Controller previousController;

    public Controller(MisterC program, Controller previousController) {
        this.currentProgram = program;
        this.previousController = previousController;
    }

    public abstract void handle();

    public abstract void paint();

}
