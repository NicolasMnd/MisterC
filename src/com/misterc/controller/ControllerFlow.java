package com.misterc.controller;

public abstract class ControllerFlow extends Controller {

    /**
     * The state of the controller
     */
    private State state;

    public ControllerFlow(MisterC c, Controller previous) {
        super(c, previous);
        this.state = initStates()[0];
    }

    public abstract State[] initStates();

    /**
     * Returns the current state of the program
     * @return state of the program
     */
    protected State getState() {
        return this.state.clone();
    }

    /**
     * Puts the controller in the next state
     */
    protected void nextState(String type) {
        this.state = this.state.nextState(type);
    }

    /**
     * Puts the controller in a previous state
     */
    protected void previousState() {
        this.state = this.state.previousState();
    }

}