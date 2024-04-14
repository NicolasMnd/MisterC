package com.misterc.controller;

public abstract class MisterC {

    /**
     * The controller used to control the program flow.
     */
    protected Controller controller;

    public MisterC() {}

    /**
     * Sets a new controller to the program flow
     * @param controller the new controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Initiates the program loop
     */
    public final void loop() {
        while(true) {
            controller.paint();
            controller.handle();
        }
    }

}
