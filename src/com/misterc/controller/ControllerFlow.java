package com.misterc.controller;

public abstract class ControllerFlow extends Controller {

    /**
     * The state of the controller
     */
    private int state = 0;

    public ControllerFlow(MisterC c, Controller previous) {
        super(c, previous);
    }

    /**
     * Gets the current state
     * @return the state of the controller;
     */
    protected int getState() {
        return this.state;
    }

    /**
     * Increases the state of this controller
     */
    protected final void nextState() {
        state++;
    }

    protected final void previousState() {
        state--;
    }

    @Override
    public void handle() {
        return;
    }

    @Override
    public void paint() {
        return;
    }

}