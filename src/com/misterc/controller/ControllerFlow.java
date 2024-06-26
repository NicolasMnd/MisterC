package com.misterc.controller;

import com.misterc.input.InputType;

/**
 * Controller flow is used to make a sequenced interaction with the user. It takes in {@link BaseState} objects
 * and can go through them depending on their settings.
 */
public abstract class ControllerFlow extends Controller {

    /**
     * The state of the controller
     */
    BaseState state;
    /**
     * The latest {@link ActionResult}
     */
    ActionResult result = null;

    public ControllerFlow(MisterC c, Controller previous) {
        super(c, previous);
        this.state = setStartState();
    }

    /**
     * Sets the start state of this program.
     */
    public abstract BaseState setStartState();

    @Override
    public void handle(InputType input) {
        if(state.equalsExit(input)) exit();
        if(back(input)) return;
        this.result = this.state.handle(input);
    }

    /**
     * Returns the current state of the program
     * @return state of the program
     */
    public BaseState getState() {
        return this.state;
    }

    /**
     * Exits the program by going to the previous controller
     */
    protected void exit() {
        this.currentProgram.setController(previousController);
    }

    /**
     * Goes to the previous state if the input was 'b'
     * @param input the input of the main loop
     * @return a boolean determining if the input was indeed 'b'
     */
    protected boolean back(InputType input) {
        if(state.equalsBack(input)) {
            if(state.back() == null) this.currentProgram.setController(previousController);
            this.state = this.state.back();
            return true;
        }
        return false;
    }

    /**
     * Prints the {@link ActionResult#getMessage()}
     */
    protected void printMessage() {
        if(result != null && result.getMessage() != null)
            System.out.println(result.getMessage());
    }

}