package com.misterc.controller.states;

import com.misterc.controller.ActionResult;
import com.misterc.controller.BaseState;
import com.misterc.controller.ControllerFlow;
import com.misterc.input.InputType;

public class SecondStateTest extends BaseState {

    public SecondStateTest(ControllerFlow flow) {
        super(flow, "second");
    }


    @Override
    public BaseState back() {
        return new StartStateTest(this.controller);
    }

    @Override
    public ActionResult handle(InputType input) {
        this.nextState(new ThirdStateTest(this.controller));
        return null;
    }

    @Override
    public void render() {

    }
}
