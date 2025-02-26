package Clanker.parser;


import java.util.Arrays;
import java.util.Scanner;

public class userInputParser {
    private static final Scanner scanner = new Scanner(System.in);
    private String userInput;
    private String[] parsedInput;

    /**
     * Reads and stores user input from the console.
     */
    public void readUserInput() {
        this.userInput = scanner.nextLine().trim();
        this.parsedInput = userInput.split(" ");
    }

    /**
     * Returns the raw user input string.
     * @return User input as a string.
     */
    public String getUserInput() {
        return this.userInput;
    }

    /**
     * Returns the user input as an array of words.
     * @return Parsed user input array.
     */
    public String[] getParsedInput() {
        return this.parsedInput;
    }

    /**
     * Returns the first word (command) from the parsed input.
     * @return The command word.
     */
    public String getCommand() {
        return parsedInput.length > 0 ? parsedInput[0] : "";
    }

    /**
     * Returns the remaining words after the command as a joined string.
     * @return Arguments as a string.
     */
    public String getArguments() {
        return String.join(" ", Arrays.copyOfRange(parsedInput, 1, parsedInput.length));
    }

    /**
     * Closes the scanner. Should be called before program exits.
     */
    public static void closeScanner() {
        scanner.close();
    }
}
