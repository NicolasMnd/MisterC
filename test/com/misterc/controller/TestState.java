package com.misterc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestState {

    BaseState start, scen1, scen2;

    @BeforeEach
    public void init() {
        start = new BaseState("start");
        scen1 = new BaseState("scen1");
        scen2 = new BaseState("scen2");

        start.addNext(scen1, scen2);
    }

    @Test
    public void assertStartNull() {
        assertNull(start.previousState());
    }

    @Test
    public void assertScenNotNull() {
        assertNotNull(scen1.previousState());
    }

    @Test
    public void assertStartNextNotNull() {
        assertNotNull(start.nextState("scenario1"));
    }

    @Test
    public void assertStartNextWrongName() {
        assertNotNull(start.nextState("sceario1"));
    }

    private static class StateTest extends BaseState {
        private final String test;
        StateTest(String test) {
            super("test");
            this.test = test;
        }
        @Override
        public ActionResult handle(String input) {
            if(test.equals("success")) return new ActionResult(Result.SUCCESS);
            return new ActionResult(Result.SUCCESS);
        }
        @Override
        public void render() {

        }
    }

}
