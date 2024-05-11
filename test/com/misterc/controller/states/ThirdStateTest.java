package com.misterc.controller.states;

import com.misterc.controller.ActionResult;
import com.misterc.controller.BaseState;
import com.misterc.controller.ControllerFlow;

public class ThirdStateTest extends BaseState {

    public ThirdStateTest(ControllerFlow flow) {
        super(flow, "third");

    }

    @Override
    public BaseState back() {
        return new SecondStateTest(this.controller);
    }

    @Override
    public ActionResult handle(String input) {
        this.nextState(new StartStateTest(this.controller));
        return null;
    }

    @Override
    public void render() {

    }
}
