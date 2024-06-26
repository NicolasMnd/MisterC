package com.misterc.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScannerInput implements InputHandler {

    private final InputStream systemInput;

    public ScannerInput() {
        this.systemInput = System.in;
    }

    /**
     * Will return the given input in String format.
     * @return string
     */
    @Override
    public InputType<String> getInput() {

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

            return new InputType(input[0]);

        } catch(Exception e) {
            System.out.println("[InputHandler#readString]: getting input failed");
        }

        return null;

    }

    @Override
    public boolean stop(InputType type) {
        return type.getData().equals("-#end");
    }

}
