package com.misterc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * States will always follow a tree structure. Nodes
 */
public class State {

    private final String STATE;
    private List<State> next = new ArrayList<>();
    private State previous;

    public State(String state) {
        this.STATE = state;
    }

    State(String state, List<State> next, State previous) {
        this.STATE = state;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Binds the given state as the next state of this state.
     * this -> param
     * @param state the state that should be set as next
     * @return the given state with previous as this
     */
    public final void addNext(State... state) {
        this.next.addAll(Arrays.stream(state).toList());
    }

    /**
     * Puts the given state as a previous state of this state.
     * So {@link State#previousState()} is the given parameter.
     * @param state the state that should be the previous state of this
     */
    public final void addPrevious(State state) {
        this.previous = state;
    }

    State previousState() {
        return this.previous;
    }


    State nextState(String type) {
        for(State i : next)
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
        if(this instanceof State state) return state.STATE.equals(STATE);
        return false;
    }

    @Override
    protected State clone() {
        return new State(new String(STATE), next, previous);
    }
}
