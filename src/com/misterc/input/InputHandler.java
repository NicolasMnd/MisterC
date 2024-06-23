package com.misterc.input;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

    private final InputStream systemInput;

    public InputHandler() {
        this.systemInput = System.in;
    }

    /**
     * Will try parsing input to integer. Upon failing, it will return null.
     * @return an {@link Integer} object or null value
     */
    public static Integer readInteger() {
        Scanner scanner = new Scanner(System.in);
        Object input;

        while (true) {
            try {
                input = scanner.nextLine();

                if (input != null) {
                    try {
                        return new Wrapper(Integer.parseInt((String) input)).getInt();
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    /**
     * Will return the given input in String format.
     * @return string
     */
    public String readString() {

        try {
            StringBuilder builder = new StringBuilder();

            if (System.in.available() > 0) {
                InputStreamReader inputReader = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(inputReader);

                while (reader.ready()) {
                    builder.append(reader.readLine()).append(System.lineSeparator());
                }
            } else {
                if(System.in != systemInput)
                    System.setIn(systemInput);
                Scanner s = new Scanner(System.in);
                builder.append(s.nextLine());
            }


            String[] input = builder.toString().trim().split(System.lineSeparator());

            List<String> rest = new ArrayList<>();
            for (int i = 1; i < input.length; i++)
                rest.add(input[i]);

            if (!(rest.isEmpty())) {
                String remainingInput = rest.stream().collect(Collectors.joining(System.lineSeparator()));
                ByteArrayInputStream remainingInputStream = new ByteArrayInputStream(remainingInput.getBytes());
                System.setIn(remainingInputStream);
            }

            return input[0];

        } catch(Exception e) {
            System.out.println("[InputHandler#readString]: getting input failed");
        }

        return null;

    }


    /**
     * Will strip the given input of any numbers.
     * @param input a string
     * @return returns the string part
     */
    public static String getStringPart(String input) {
        return input.replaceAll("[0-9]", "");
    }

    /**
     * Will strip the given input of string
     * @param input a string
     * @return a string value with numbers only
     */
    public static Integer getNumberPart(String input) {
        String numberStr = input.replaceAll("[^-?0-9]", "");
        try {
            return Integer.parseInt(numberStr);
        } catch(NumberFormatException e) {
            // Unlucky
        }
        return null;
    }

    /**
     * Will strip the given input of string
     * @param input a string
     * @return a string value with numbers only
     */
    public static Integer getNumberPartSafely(String input, int replacement) {
        String numberStr = input.replaceAll("[^0-9]", "");
        try {
            return Integer.parseInt(numberStr);
        } catch(NumberFormatException e) {
            // Unlucky
        }
        return replacement;
    }

}
