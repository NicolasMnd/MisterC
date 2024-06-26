package com.misterc.controller;

import com.misterc.input.InputType;

public abstract class Controller {

    protected final MisterC currentProgram;
    protected final Controller previousController;

    public Controller(MisterC program, Controller previousController) {
        this.currentProgram = program;
        this.previousController = previousController;
    }

    public MisterC getCurrentProgram() {
        return this.currentProgram;
    }

    public abstract void handle(InputType input);

    public abstract void paint();

}
