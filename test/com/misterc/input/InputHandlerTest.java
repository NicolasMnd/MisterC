package com.misterc.input;

import com.misterc.input.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InputHandlerTest {

    @BeforeEach
    public void init() {
    }

    @Test
    public void testReadStringCorrectly() {
        setInputStream("hello");
        assertEquals(InputHandler.readString(), "hello");
    }

    @Test
    public void testSplitStringIntegerNonSplit() {
        setInputStream("hellomister545");
        String a = InputHandler.readString();
        assertEquals(InputHandler.getStringPart(a), "hellomister");
        assertEquals(InputHandler.getNumberPart(a), 545);
    }

    @Test
    public void testSplitStringInteger_Split() {
        setInputStream("4hellom5ister9");
        String a = InputHandler.readString();
        assertEquals(InputHandler.getStringPart(a), "hellomister");
        assertEquals(InputHandler.getNumberPart(a), 459);
    }

    @Test
    public void testNegativeNumber_NoString() {
        setInputStream("-50");
        Integer a = InputHandler.getNumberPart(InputHandler.readString());
        assertEquals(a, -50);
    }

    @Test
    public void testGetNumbers_NoNumbers() {
        setInputStream("hello");
        assertNull(InputHandler.getNumberPart(InputHandler.readString()));
    }

    @Test
    public void readInteger_NoInteger() {
        setInputStream("mister");
        assertNull(InputHandler.readInteger());
    }

    @Test
    public void readInteger_Integer() {
        setInputStream("5");
        assertEquals(InputHandler.readInteger(), 5);
    }

    @Test
    public void readInteger_IntegerAndString() {
        setInputStream("mister5");
        assertNull(InputHandler.readInteger());
    }

    @Test
    public void readIntegerSafely_IntegerONly() {
        setInputStream("1");
        String s = InputHandler.readString();
        assertEquals(InputHandler.getNumberPartSafely(s, -1), 1);
    }

    @Test
    public void readIntegerSafely_IntegerAndString() {
        setInputStream("1sdfsd2");
        String s = InputHandler.readString();
        assertEquals(InputHandler.getNumberPartSafely(s, -1), 12);
    }

    @Test
    public void readIntegerSafely_StringOnly() {
        setInputStream("sdfsd");
        String s = InputHandler.readString();
        assertEquals(InputHandler.getNumberPartSafely(s, -1), -1);
    }

    private void setInputStream(String input) {
        String beginning = input + "\n";
        List<InputStream> streams = List.of(
                new ByteArrayInputStream(beginning.getBytes()));
        InputStream story = new SequenceInputStream(Collections.enumeration(streams));
        System.setIn(story);
    }

}
