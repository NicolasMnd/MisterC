package com.misterc.controller;

public class ActionResult {

    /**
     * The {@link Result} of the action
     */
    private final Result result;
    private final String message;

    public ActionResult(Result result) {
        this.result = result;
        this.message = null;
    }

    public ActionResult(Result result, String message) {
        this.result = result;
        this.message = message;
    }

    /**
     * Get the message from the result
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Returns the result of this action
     * @return a {@link Result} object.
     */
    public Result getResult() {
        return this.result;
    }

}
