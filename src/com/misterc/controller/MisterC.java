package com.misterc.controller;

import com.misterc.input.InputHandler;

public abstract class MisterC {

    /**
     * The controller used to control the program flow.
     */
    protected Controller controller;
    private boolean run = true;

    public MisterC() {}

    /**
     * Sets a new controller to the program flow
     * @param controller the new controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Stops the current program
     */
    public final void stop() {
        this.run = false;
    }

    /**
     * Initiates the program loop
     */
    public final void loop() {
        while(run) {
            controller.paint();
            String input = InputHandler.readString();
            controller.handle(input);
        }
    }
    

}
