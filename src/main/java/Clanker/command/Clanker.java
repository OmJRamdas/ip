package Clanker.command;

import Clanker.Ui.Ui;

public class Clanker {
    /**
     *  Overall program for Clanker
     */
    private static void chatBotProgram() {
        Ui.greet();
        clankerProgram.run();
        Ui.goodbye();
    }

    public static void main(String[] args) {
       chatBotProgram();
    }
}
