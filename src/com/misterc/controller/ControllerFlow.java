package com.misterc.controller;

/**
 * Controller flow is used to make a sequenced interaction with the user. It takes in {@link State} objects
 * and can go through them depending on their settings.
 */
public abstract class ControllerFlow extends Controller {

    /**
     * The state of the controller
     */
    private State state;

    public ControllerFlow(MisterC c, Controller previous) {
        super(c, previous);
        this.state = initStates()[0];
    }

    /**
     * Each ControllerFlow consists of an array of states. This method retrieves the registered states.
     * Later, this generic class will use these states for executing {@link ControllerFlow#nextState(String)}
     * and {@link ControllerFlow#previousState()}
     * @return an array of all states used in this program
     */
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

    /**
     * Exits the program by going to the previous controller
     */
    protected void exit() {
        this.currentProgram.setController(previousController);
    }

}