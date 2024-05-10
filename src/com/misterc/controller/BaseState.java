package com.misterc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generic state object
 */
public abstract class BaseState implements State {

    /**
     * The string representation of this state. Used to identify & differentiate between states
     */
    private final String STATE;
    /**
     * The list of {@link BaseState} objects that are followed by this one
     */
    private List<BaseState> next = new ArrayList<>();
    /**
     * The previous state of this state
     */
    private BaseState previous;

    public BaseState(String state) {
        this.STATE = state;
    }

    BaseState(String state, List<BaseState> next, BaseState previous) {
        this.STATE = state;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Binds the given state as the next state of this state.
     * this -> param
     * @param state the state that should be set as next
     */
    public final void addNext(BaseState... state) {
        this.next.addAll(Arrays.stream(state).toList());
    }

    /**
     * Puts the given state as a previous state of this state.
     * So {@link BaseState#previousState()} is the given parameter.
     * @param state the state that should be the previous state of this
     */
    public final void addPrevious(BaseState state) {
        this.previous = state;
    }

    /**
     * Returns the previous assigned state
     * @return the {@link BaseState} object corresponding to the previous state
     */
    BaseState previousState() {
        return this.previous;
    }

    /**
     * Finds the next state based upon the string that is given for that state
     * @param type the state name
     * @return the {@link BaseState} corresponding to the given string
     */
    BaseState nextState(String type) {
        for(BaseState i : next)
            if(i.identifier().equals(type)) return i;
        return this;
    }

    /**
     * Returns the identifier of this state
     * @return the string version of the state
     */
    public String identifier() {
        return new String(this.STATE);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseState state) return state.STATE.equals(STATE);
        return false;
    }

}
