package com.misterc.controller;

class Main extends MisterC {

    public static int WIDTH = 100;
    public static int HEIGHT = 60;

    public Main() {
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
        public void handle(String input) {

        }

        @Override
        public void paint() {
            System.out.println("Painted");
        }
    }

}