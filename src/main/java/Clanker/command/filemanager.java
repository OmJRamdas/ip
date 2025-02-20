package Clanker.command;

import Clanker.task.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class filemanager {
    private final String filePath;

    public filemanager(String filePath) {
        this.filePath = filePath;
        ensureFileExists();
    }

    /**
     * Ensure that the data directory and task file exist.
     */
    private void ensureFileExists() {
        File file = new File(filePath);
        File directory = file.getParentFile();

        try {
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directory created: " + directory.getAbsolutePath());
                } else {
                    System.out.println("Failed to create directory!");
                }
            }

            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed to create file!");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while ensuring file existence.");
            e.printStackTrace();
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
            return tasks; // If the file doesn't exist, return an empty list
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

        char type = line.charAt(1); // T, D, E
        boolean isDone = line.charAt(4) == 'X'; // 'X' means done

        String details = line.substring(7).trim(); // Skip "[T][ ] " or "[D][X] "

        switch (type) {
        case 'T': {
            Todo todo = new Todo(details);
            if (isDone) todo.markAsDone();
            return todo;
        }
        case 'D': {
            String[] parts = details.split(" \\(by: ", 2);
            String description = parts[0].trim();
            String by = parts[1].substring(0, parts[1].length() - 1); // remove closing ')'
            Deadline deadline = new Deadline(description, by);
            if (isDone) deadline.markAsDone();
            return deadline;
        }
        case 'E': {
            String[] parts = details.split(" \\(from: | to: ", 3);
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].substring(0, parts[2].length() - 1); // remove closing ')'
            Event event = new Event(description, from, to);
            if (isDone) event.markAsDone();
            return event;
        }
        default:
            throw new IllegalArgumentException("Invalid task type in file: " + type);
        }
    }

}
