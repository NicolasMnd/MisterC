package com.misterc.input;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

    public InputHandler() {

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
    public static String readString() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while(true) {
            try {
                StringBuilder inputBuilder = new StringBuilder();
                String line;

                // Loop until input is received
                while (true) {
                    // Check if input is available
                    if (System.in.available() > 0) {
                        // Read all lines from the input stream
                        while ((line = reader.readLine()) != null) {
                            inputBuilder.append(line).append(System.lineSeparator());
                            break;
                        }
                        break; // Exit the loop when input is read
                    }
                    // Sleep briefly to avoid CPU-intensive spinning
                    Thread.sleep(100);
                }

                String input = inputBuilder.toString().trim(); // Remove leading/trailing whitespaces

                // Process each line separately
                String[] lines = input.split(System.lineSeparator());
                if (lines.length > 0 && !lines[0].isEmpty())
                    return lines[0];

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
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
