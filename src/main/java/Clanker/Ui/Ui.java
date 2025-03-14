package Clanker.Ui;

public class Ui {
    private static final String LINE = "____________________________________________________________";
    private static final String LOGO = " _____ _             _\n"
            + "/  __ \\ |           | |\n"
            + "| /  \\/ | __ _ _ __ | | _____ _ __\n"
            + "| |   | |/ _` | '_ \\| |/ / _ \\ '__|\n"
            + "| \\__/\\ | (_| | | | |   <  __/ |\n"
            + " \\____/_|\\__,_|_| |_|_|\\_\\___|_|\n";

    private static final String HELP = """
            help        list all commands and functions
            ls          list all tasks
            todo        add todo
            deadline    add deadline
            event       add event
            mark        mark task as done
            unmark      mark task as undone
            delete      delete task
            find        find task(s)
            blast-em    exit program
            """;

    /**
     *  Greeting Function for Clanker
     */
    public static void greet() {
        System.out.println(LINE);
        System.out.println(LOGO + "\n"+ "ROGER ROGER What can I do for you?");
        System.out.println(LINE);
    }

    /**
     *  Goodbye function for Clanker
     */
    public static void goodbye() {
        System.out.println("ROGER ROGER! Hope to see you soon");
        System.out.println(LINE);
    }

    /**
     *  Print help to descibe functions in program
     */
    public static void help() {
        System.out.println(HELP);
    }

    public static void printLine() {
        System.out.println(LINE);
    }
}
