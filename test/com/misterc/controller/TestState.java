package com.misterc.controller;

import com.misterc.controller.states.SecondStateTest;
import com.misterc.controller.states.StartStateTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestState {

    static BaseState start, scen1, scen2, scen3;
    ControllerFlow c, prev;
    MisterC mister;

    @BeforeEach
    public void init() {
        mister = new MisterCInstance();

        prev = new ControllerFlowInstance(mister, null);
        c = new ControllerFlowInstance(mister, prev);

        mister.setController(c);
    }

    @Test
    public void testHandle_Controller_Exit() {
        c.handle("e");
        assertEquals(mister.controller, prev);
    }

    @Test
    public void testExit_Controller() {
        c.exit();
        assertEquals(mister.controller, prev);
    }

    @Test
    public void testHandle_Controller_Back_StartState_Null() {
        c.handle("b");
        assertNull(c.state);
    }

    @Test
    public void testHandle_Controller_Back_NonStartState() {
        c.handle("mister"); // Will be passed to state, state will always go to next state in this case
        c.handle("b"); //
        assertEquals(c.state, new StartStateTest(this.c));
    }

    @Test
    public void testGetStateController() {
        assertEquals(c.getState(), new StartStateTest(c));
    }

    @Test
    public void testEqualsSameState() {
        assertEquals(start, start);
    }

    @Test
    public void testEqualsObject() {
        assertNotEquals(start, "optee");
    }

    public static class ControllerFlowInstance extends ControllerFlow {

        public ControllerFlowInstance(MisterC c, Controller prev) {
            super(c, prev);
        }

        @Override
        public BaseState setStartState() {
            return new StartStateTest(this);
        }

        @Override
        public void paint() {
        }

    }


    private static class MisterCInstance extends MisterC {
    }

}
