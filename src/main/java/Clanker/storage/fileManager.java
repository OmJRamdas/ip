package Clanker.storage;

import Clanker.task.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class fileManager {
    private final String filePath;

    private static final String DIRECTORY_CREATION_SUCCESS = "Directory created: ";
    private static final String DIRECTORY_CREATION_FAILURE = "Failed to create directory!";
    private static final String FILE_CREATION_SUCCESS = "File created: ";
    private static final String FILE_CREATION_FAILURE = "Failed to create file!";
    private static final String FILE_ERROR = "An error occurred while ensuring file existence.";
    private static final char TASK_TODO = 'T';
    private static final char TASK_DEADLINE = 'D';
    private static final char TASK_EVENT = 'E';
    private static final char TASK_DONE = 'X';
    private static final int TASK_TYPE_INDEX = 1;
    private static final int TASK_DONE_INDEX = 4;
    private static final int TASK_DETAILS_START_INDEX = 7;

    /**
     * FileManager Constructor
     * @param filePath filepath
     */
    public fileManager(String filePath) {
        this.filePath = filePath;
        ensureFileExists();
    }

    private void ensureFileExists() {
        File file = new File(filePath);
        File directory = file.getParentFile();

        try {
            if (!directory.exists() && !directory.mkdirs()) {
                System.out.println(DIRECTORY_CREATION_FAILURE);
                return;
            }
            System.out.println(DIRECTORY_CREATION_SUCCESS + directory.getAbsolutePath());

            if (!file.exists() && !file.createNewFile()) {
                System.out.println(FILE_CREATION_FAILURE);
                return;
            }
            System.out.println(FILE_CREATION_SUCCESS + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(FILE_ERROR);
        }
    }

    /**
     * Saves the list of tasks to the file.
     *
     * @param tasks The list of tasks to save.
     * @throws IOException If there is an error writing to the file.
     */
    public void saveTasks(ArrayList<Task> tasks) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Loads tasks from the file.
     *
     * @return An ArrayList of Task objects.
     * @throws IOException If there is an error reading the file.
     */
    public ArrayList<Task> loadTasks() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isBlank()) {
                    Task task = parseTaskFromFile(line);
                    tasks.add(task);
                }
            }
        }

        return tasks;
    }

    /**
     * Parses a task from a line of the file.
     *
     * @param line The line representing a task.
     * @return A Task object.
     */
    private Task parseTaskFromFile(String line) {
        char type = line.charAt(TASK_TYPE_INDEX);
        boolean isDone = line.charAt(TASK_DONE_INDEX) == TASK_DONE;
        String details = line.substring(TASK_DETAILS_START_INDEX).trim();

        switch (type) {
        case TASK_TODO:
            Todo todo = new Todo(details);
            if (isDone) todo.markAsDone();
            return todo;
        case TASK_DEADLINE:
            String[] deadlineParts = details.split(" \\(by: ", 2);
            String deadlineDesc = deadlineParts[0].trim();
            String by = deadlineParts[1].substring(0, deadlineParts[1].length() - 1);
            Deadline deadline = new Deadline(deadlineDesc, by);
            if (isDone) deadline.markAsDone();
            return deadline;
        case TASK_EVENT:
            String[] eventParts = details.split(" \\(from: | to: ", 3);
            String eventDesc = eventParts[0].trim();
            String from = eventParts[1].trim();
            String to = eventParts[2].substring(0, eventParts[2].length() - 1);
            Event event = new Event(eventDesc, from, to);
            if (isDone) event.markAsDone();
            return event;
        default:
            throw new IllegalArgumentException("Invalid task type in file: " + type);
        }
    }
}