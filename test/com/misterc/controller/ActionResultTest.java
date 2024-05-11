package com.misterc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ActionResultTest {

    ActionResult successNoMessage, success;

    @BeforeEach
    public void init() {
        success = new ActionResult(Result.SUCCESS, "joepie");
        successNoMessage = new ActionResult(Result.FAIL);
    }

    @Test
    public void testActionResultMessage() {
        assertEquals(success.getMessage(), "joepie");
    }

    @Test
    public void testActionResultMessage_NoMessage() {
        assertNull(successNoMessage.getMessage());
    }

    @Test
    public void testGetResult_FAIL() {
        assertEquals(successNoMessage.getResult(), Result.FAIL);
    }

    @Test
    public void testGetResult_SUCCESS() {
        assertEquals(success.getResult(), Result.SUCCESS);
    }

}
