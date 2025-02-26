package Clanker.command;

import java.io.*;
import Clanker.parser.userInputParser;
import Clanker.storage.filemanager;
import Clanker.task.*;
import Clanker.exceptions.*;
import Clanker.Ui.Ui;


public class clankerProgram {

    /**
     *  Main program
     */
    public static void run() {
        filemanager manager = new filemanager("data/clanker.txt");
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
            case "delete":
                tasks.deleteTask(Integer.parseInt(remainingWords));
                break;
            default:
                throw new InvalidCommandException(inputParser.getUserInput());
        }
    }
}
