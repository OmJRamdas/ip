package Clanker.command;

import java.io.*;
import java.util.*;
import Clanker.parser.*;
import Clanker.task.*;
import Clanker.exceptions.*;


public class clankerProgram {
    private static final String LINE = "____________________________________________________________";

    /**
     *  Main run program for Clanker
     */
    public static void run() {
        filemanager manager = new filemanager("data/clanker.txt");
        String userCommand;
        String[] userCommandParts;
        Tasks tasks;

        try {
            tasks = new Tasks(manager.loadTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        do {
            userCommand = userInputParser.getUserInput();
            userCommandParts = userCommand.split(" ");

            try {
                handleCommand(userCommandParts, tasks, userCommand);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println(LINE);
        } while (!userCommandParts[0].equals("blast-em"));

        try {
            manager.saveTasks(tasks.getTasksList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles command
     * @param parts, breakdown of input
     * @param tasks, tasks
     * @param userCommand, the original input string (for error messages)
     */

    private static void handleCommand(String[] parts, Tasks tasks, String userCommand) {
        String remainingWords = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));

        switch (parts[0]) {
            case "blast-em":
                break;
            case "mark":
                tasks.markTask(Integer.parseInt(parts[1]));
                break;
            case "unmark":
                tasks.unmarkTask(Integer.parseInt(parts[1]));
                break;
            case "ls":
                tasks.getTasks();
                break;
            case "todo":
                tasks.addTodo(remainingWords);
                break;
            case "deadline":
                tasks.addDeadline(remainingWords);
                break;
            case "event":
                tasks.addEvent(remainingWords);
                break;
            default:
                throw new InvalidCommandException(userCommand);
        }
    }
}
