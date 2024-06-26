package com.misterc.controller;

import com.misterc.input.InputType;
import com.misterc.input.ScannerInput;

class Main extends MisterC {

    public static int WIDTH = 100;
    public static int HEIGHT = 60;

    public Main() {
        super(new ScannerInput());
        this.setController(new Cd(this));
    }

    public static void main(/*String[] args*/) {
        Main main = new Main();
        main.loop();
    }

    public static class Cd extends Controller {
        public Cd(MisterC c) {
            super(c, null);
        }

        @Override
        public void handle(InputType input) {

        }

        @Override
        public void paint() {
            System.out.println("Painted");
        }
    }

}