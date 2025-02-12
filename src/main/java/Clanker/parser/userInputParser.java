package Clanker.parser;

import java.util.*;

public class userInputParser {

    public static String userInput;
    public static Scanner scanner = new Scanner(System.in);

    /**
     *  Scanner for user input
     */
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
