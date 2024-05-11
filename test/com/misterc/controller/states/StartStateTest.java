package com.misterc.controller.states;

import com.misterc.controller.ActionResult;
import com.misterc.controller.BaseState;
import com.misterc.controller.ControllerFlow;

public class StartStateTest extends BaseState {

    public StartStateTest(ControllerFlow flow) {
        super(flow, "start");
    }

    @Override
    public BaseState back() {
        return null;
    }

    @Override
    public ActionResult handle(String input) {
        this.nextState(new SecondStateTest(this.controller));
        return null;
    }

    @Override
    public void render() {

    }
}
