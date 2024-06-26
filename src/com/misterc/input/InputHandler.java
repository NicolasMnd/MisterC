package com.misterc.input;

public interface InputHandler {

    InputType getInput();

    boolean stop(InputType type);

}
