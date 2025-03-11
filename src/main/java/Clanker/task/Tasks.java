package Clanker.task;

import java.util.ArrayList;
import Clanker.exceptions.*;
import java.util.List;


public class Tasks {
    private ArrayList<Task> tasks;

    public Tasks(ArrayList<Task> input) {
        tasks = input;
    }

    /**
     *  Mark task as done
     * @param number, task number
     */
    public void markTask(int number) {
        try {
            Task task = tasks.get(number - 1);
            task.markAsDone();
            System.out.println("ROGER ROGER! This Task has been marked as done");
            System.out.println(task.toString());
        } catch (Exception e) {
            System.out.println("Error in marking task: " + number + ". Reason: " + e.getMessage());
        }
    }

    /**
     *  Mark ith task as undone
     * @param number, task number
     */
     public void unmarkTask(int number) {
        try {
            Task task = tasks.get(number - 1);
            task.markAsNotDone();
            System.out.println("ROGER ROGER! This Task has been marked as not done");
            System.out.println(task.toString());
        } catch (Exception e) {
            System.out.println("Error in unmarking task: " + number + ". Reason: " + e.getMessage());
        }
    }

    /**
     * Add todo to Tasks
     * @param task, Todo
     */
    public void addTodo(String task) {
        if (task.isBlank()) { // Check if the description is empty
            throw new EmptyDescriptionException("todo");
        }
        try {
            Task newTask = new Todo(task);
            tasks.add(newTask);
            System.out.println("ROGER ROGER Adding the following Todo: " + newTask.toString());
            System.out.println("Now you have " + tasks.size() + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding Todo " + task + ". Reason: " + e.getMessage());
        }
    }

    /**
     * Add deadline to Tasks
     * @param task, Deadline
     */
    public void addDeadline(String task) {
        if (task.isBlank()) { // Check if the description is empty
            throw new EmptyDescriptionException("deadline");
        }

        try {
            String[] parts = task.split("/by ", 2);
            Task newTask = new Deadline(parts[0], parts[1]);
            tasks.add(newTask);

            System.out.println("ROGER ROGER Adding the following Deadline: " + newTask.toString());
            System.out.println("Now you have " + tasks.size() + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding deadline: " + task + ". Reason: " + e.getMessage());
        }
    }

    /**
     * Add Event to tasks
     * @param task
     */
    public void addEvent(String task) {
        if (task.isBlank()) { // Check if the description is empty
            throw new EmptyDescriptionException("event");
        }

        try {
            String[] parts = task.split("/from | /to ", 3);
            Task newTask = new Event(parts[0], parts[1], parts[2]);
            tasks.add(newTask);
            System.out.println("ROGER ROGER Adding the following Event: " + newTask.toString());
            System.out.println("Now you have " + tasks.size() + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding event: " + task + ". Reason: " + e.getMessage());
        }
    }

    /**
     *  Get all tasks
     */
    public void getTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }
        System.out.println("ROGER ROGER Here are the tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }

    /**
     * To delete task
     * @param number task number
     */
    public void deleteTask(int number) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete");
            return;
        } else if (number > tasks.size() || number <= 0) {
            System.out.println("Task number out of bounds");
            return;
        }

        try {
            Task task = tasks.get(number - 1);
            System.out.println("ROGER ROGER! Deleting Task: " );
            System.out.println(task.toString());
            tasks.remove(number - 1);
            System.out.println("Now you have " + tasks.size() + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in deleting task: " + (number));
        }
    }

    /**
     *  Get all tasks
     * @return tasks
     */
    public ArrayList<Task> getTasksList() {
        return tasks;
    }

    /**
     * Find tasks containing a keyword and print their task numbers.
     * @param keyword the search keyword
     */
    public void findTasks(String keyword) {
        List<Integer> foundIndices = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().toLowerCase().contains(keyword.toLowerCase())) {
                foundIndices.add(i + 1);
            }
        }

        if (foundIndices.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("ROGER ROGER! Here are the matching tasks:");
            for (int index : foundIndices) {
                System.out.println(index + ". " + tasks.get(index - 1).toString());
            }
        }
    }

}
