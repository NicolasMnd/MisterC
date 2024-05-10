package com.misterc.controller;

public abstract class ActionResult {

    /**
     * The {@link Result} of the action
     */
    private final Result result;

    public ActionResult(Result result) {
        this.result = result;
    }

    /**
     * Returns the result of this action
     * @return a {@link Result} object.
     */
    public Result getResult() {
        return this.result;
    }

}
