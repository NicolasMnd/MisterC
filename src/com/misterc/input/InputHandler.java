package com.misterc.input;

import java.util.Scanner;

public class InputHandler {

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
        Scanner scanner = new Scanner(System.in);
        Object input;

        while (true) {
            try {
                input = scanner.nextLine();

                if (input != null) {
                    return (new Wrapper(String.valueOf(input))).getStrValue();
                }

            } catch (Exception e) {
                System.out.println("Invalid input.");
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
        String numberStr = input.replaceAll("[^0-9]", "");
        try {
            int i = Integer.parseInt(numberStr);
            return i;
        } catch(NumberFormatException e) {
            // Unlucky
        }
        return null;
    }


}
