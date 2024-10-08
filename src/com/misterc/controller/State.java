package com.misterc.controller;

import com.misterc.input.InputType;

public interface State {

    /**
     * Handles input for this state
     * @param input the input that is to be handled by the state
     * @return an {@link ActionResult} object which gives information about the handling of the input
     */
    ActionResult handle(InputType input);

    /**
     * Renders any relevant information for this state
     */
    void render();

}
