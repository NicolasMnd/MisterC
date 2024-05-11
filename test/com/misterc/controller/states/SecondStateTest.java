package com.misterc.controller.states;

import com.misterc.controller.ActionResult;
import com.misterc.controller.BaseState;
import com.misterc.controller.ControllerFlow;

public class SecondStateTest extends BaseState {

    public SecondStateTest(ControllerFlow flow) {
        super(flow, "second");
    }


    @Override
    public BaseState back() {
        return new StartStateTest(this.controller);
    }

    @Override
    public ActionResult handle(String input) {
        this.nextState(new ThirdStateTest(this.controller));
        return null;
    }

    @Override
    public void render() {

    }
}
