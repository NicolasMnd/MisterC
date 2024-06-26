package com.misterc.controller;

import com.misterc.input.InputType;

/**
 * Generic state object
 */
public abstract class BaseState implements State {

    /**
     * The controller object
     */
    protected final ControllerFlow controller;
    /**
     * Name of the state
     */
    private final String NAME;

    /**
     * Creates a state object
     * @param controller the controller object
     */
    public BaseState(ControllerFlow controller, String name) {
        this.controller = controller;
        this.NAME = name;
    }

    /**
     * Accesses the {@link ControllerFlow} to modify the {@link ControllerFlow#getState()} to the parameter
     * @param state the next state
     */
    protected void nextState(BaseState state) {
        this.controller.state = state;
    }

    /**
     * Returns the state that is previous of this one.
     */
    public abstract BaseState back();

    public boolean equalsBack(InputType type) {
        return type.getData().equals("b");
    }

    public boolean equalsExit(InputType type) {
        return type.getData().equals("e");
    }

    /**
     * Returns the name of the state
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * Determines if the given object is equal to this object
     * @param obj the object which is to be compared
     * @return a boolean determining if the objects are the same
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseState state) return state.getName().equals(this.getName());
        return false;
    }

}
