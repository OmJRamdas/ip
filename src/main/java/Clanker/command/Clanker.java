package Clanker.command;

import Clanker.task.Tasks;

import java.util.Scanner;

public class Clanker {
    private static final String LINE = "____________________________________________________________";
    private static final String LOGO = " _____ _             _\n"
                + "/  __ \\ |           | |\n"
                + "| /  \\/ | __ _ _ __ | | _____ _ __\n"
                + "| |   | |/ _` | '_ \\| |/ / _ \\ '__|\n"
                + "| \\__/\\ | (_| | | | |   <  __/ |\n"
                + " \\____/_|\\__,_|_| |_|_|\\_\\___|_|\n";

    /**
     *  Greeting Function for Clanker.command.Clanker
     */
    private void greet() {
            System.out.println(LINE);
            System.out.println(LOGO + "\n"+ "ROGER ROGER what Can I do for you?");
            System.out.println(LINE);
    }

    /**
     *  Goodbye function for Clanker.command.Clanker
     */
    private void goodbye() {
        System.out.println("ROGER ROGER! Hope to see you soon");
        System.out.println(LINE);
    }


    /**
     *  Overall program for Clanker.command.Clanker
     */
    public void chatBotProgram() {
        greet();
        clankerProgram.run();
        goodbye();
    }

    public static void main(String[] args) {
        Clanker chatbot = new Clanker();
        chatbot.chatBotProgram();
    }
}
