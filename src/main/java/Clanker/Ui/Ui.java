package Clanker.Ui;

public class Ui {
    private static final String LINE = "____________________________________________________________";
    private static final String LOGO = " _____ _             _\n"
            + "/  __ \\ |           | |\n"
            + "| /  \\/ | __ _ _ __ | | _____ _ __\n"
            + "| |   | |/ _` | '_ \\| |/ / _ \\ '__|\n"
            + "| \\__/\\ | (_| | | | |   <  __/ |\n"
            + " \\____/_|\\__,_|_| |_|_|\\_\\___|_|\n";

    /**
     *  Greeting Function for Clanker
     */
    public static void greet() {
        System.out.println(LINE);
        System.out.println(LOGO + "\n"+ "ROGER ROGER what Can I do for you?");
        System.out.println(LINE);
    }

    /**
     *  Goodbye function for Clanker
     */
    public static void goodbye() {
        System.out.println("ROGER ROGER! Hope to see you soon");
        System.out.println(LINE);
    }

    public static void printLine() {
        System.out.println(LINE);
    }
}
