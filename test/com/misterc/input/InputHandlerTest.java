package com.misterc.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InputHandlerTest {

    ScannerInput handler;

    @BeforeEach
    public void init() {
        handler = new ScannerInput();
    }

    @Test
    public void testReadStringCorrectly() {
        setInputStream("hello");
        assertEquals(handler.getInput().getData(), "hello");
    }

    @Test
    public void testSplitStringIntegerNonSplit() {
        setInputStream("hellomister545");
        String a = handler.getInput().getData();
        assertEquals(InputHelper.getStringPart(a), "hellomister");
        assertEquals(InputHelper.getNumberPart(a), 545);
    }

    @Test
    public void testSplitStringInteger_Split() {
        setInputStream("4hellom5ister9");
        String a = handler.getInput().getData();
        assertEquals(InputHelper.getStringPart(a), "hellomister");
        assertEquals(InputHelper.getNumberPart(a), 459);
    }

    @Test
    public void testNegativeNumber_NoString() {
        setInputStream("-50");
        Integer a = InputHelper.getNumberPart(handler.getInput().getData());
        assertEquals(a, -50);
    }

    @Test
    public void testGetNumbers_NoNumbers() {
        setInputStream("hello");
        assertNull(InputHelper.getNumberPart(handler.getInput().getData()));
    }

    @Test
    public void readInteger_NoInteger() {
        setInputStream("mister");
        assertNull(InputHelper.readInteger());
    }

    @Test
    public void readInteger_Integer() {
        setInputStream("5");
        assertEquals(InputHelper.readInteger(), 5);
    }

    @Test
    public void readInteger_IntegerAndString() {
        setInputStream("mister5");
        assertNull(InputHelper.readInteger());
    }

    @Test
    public void readIntegerSafely_IntegerONly() {
        setInputStream("1");
        String s = handler.getInput().getData();
        assertEquals(InputHelper.getNumberPartSafely(s, -1), 1);
    }

    @Test
    public void readIntegerSafely_IntegerAndString() {
        setInputStream("1sdfsd2");
        String s = handler.getInput().getData();
        assertEquals(InputHelper.getNumberPartSafely(s, -1), 12);
    }

    @Test
    public void readIntegerSafely_StringOnly() {
        setInputStream("sdfsd");
        String s = handler.getInput().getData();
        assertEquals(InputHelper.getNumberPartSafely(s, -1), -1);
    }

    @Test
    public void setInt() {
        setInputStream("2", "3");
        String s = handler.getInput().getData();
        System.out.println("s: " + s);
    }

    private void setInputStream(String input) {
        String beginning = input + "\n";
        List<InputStream> streams = List.of(
                new ByteArrayInputStream(beginning.getBytes()));
        InputStream story = new SequenceInputStream(Collections.enumeration(streams));
        System.setIn(story);
    }

    protected void setInputStream(String... input) {
        String beginning = "";
        for(String i : input)
            beginning += i + "\n";
        beginning += "-#end\n";
        List<InputStream> streams = List.of(
                new ByteArrayInputStream(beginning.getBytes()));
        InputStream story = new SequenceInputStream(Collections.enumeration(streams));
        System.setIn(story);
    }


}
