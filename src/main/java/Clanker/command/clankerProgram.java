package Clanker.command;

import java.io.*;
import Clanker.parser.userInputParser;
import Clanker.storage.fileManager;
import Clanker.task.*;
import Clanker.exceptions.*;
import Clanker.Ui.Ui;


public class clankerProgram {
    private static final String EXIT = "blast-em";
    private static final String MARK = "mark";
    private static final String UNMARK = "unmark";
    private static final String LIST = "ls";
    private static final String DELETE = "delete";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String FIND = "find";

    /**
     *  Main program
     */
    public static void run() {
        fileManager manager = new fileManager("data/clanker.txt");
        Tasks tasks;
        userInputParser inputParser = new userInputParser();

        try {
            tasks = new Tasks(manager.loadTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        do {
            inputParser.readUserInput();

            try {
                handleCommand(inputParser, tasks);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            Ui.printLine();
        } while (!inputParser.getCommand().equals("blast-em"));

        try {
            manager.saveTasks(tasks.getTasksList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userInputParser.closeScanner();
    }

    /**
     * Handles command
     * @param inputParser, input object
     * @param tasks, tasks
     */
    private static void handleCommand(userInputParser inputParser, Tasks tasks) {
        String remainingWords = inputParser.getArguments();
        String[] parts = inputParser.getParsedInput();

        switch (inputParser.getCommand()) {
        case EXIT:
            break;
        case MARK:
            tasks.markTask(Integer.parseInt(parts[1]));
            break;
        case UNMARK:
            tasks.unmarkTask(Integer.parseInt(parts[1]));
            break;
        case LIST:
            tasks.getTasks();
            break;
        case TODO:
            tasks.addTodo(remainingWords);
            break;
        case DEADLINE:
            tasks.addDeadline(remainingWords);
            break;
        case EVENT:
            tasks.addEvent(remainingWords);
            break;
        case DELETE:
            tasks.deleteTask(Integer.parseInt(remainingWords));
            break;
        case FIND:
            tasks.findTasks(remainingWords);
            break;
        default:
            throw new InvalidCommandException(inputParser.getUserInput());
        }
    }
}
