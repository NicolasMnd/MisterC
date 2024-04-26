package com.misterc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestState {

    State start, scen1, scen2;

    @BeforeEach
    public void init() {
        start = new State("start");
        scen1 = new State("scen1");
        scen2 = new State("scen2");

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

}
