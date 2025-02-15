package Clanker.task;

import Clanker.exceptions.*;

public class Tasks {
    private Task[] tasks;
    private int index;

    public Tasks() {
        tasks = new Task[100];
        index = 0;
    }

    /**
     *  Mark task as done
     * @param number, task number
     */
    public void markTask(int number) {
        try {
            this.tasks[number].markAsDone();
            System.out.println("ROGER ROGER! This Clanker.command.Clanker.exceptions.task has been marked as done");
            System.out.println(tasks[number].toString());
        } catch (Exception e) {
            System.out.println("Error in marking Clanker.command.Clanker.exceptions.task: " + number);
        }
    }

    /**
     *  Mark task as undone
     * @param number, task number
     */
     public void unmarkTask(int number) {
        try {
            this.tasks[number].markAsNotDone();
            System.out.println("ROGER ROGER! This Clanker.command.Clanker.exceptions.task has been marked as not done");
            System.out.println(tasks[number].toString());
        } catch (Exception e) {
            System.out.println("Error in unmarking Clanker.command.Clanker.exceptions.task: " + number);
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
            tasks[index] = new Todo(task);
            System.out.println("ROGER ROGER Adding the following Clanker.task.Todo: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error adding " + task);
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
            tasks[index] = new Deadline(parts[0], parts[1]);
            System.out.println("ROGER ROGER Adding the following Clanker.command.Clanker.task.Deadline: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding event: " + task);
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
            tasks[index] = new Event(parts[0], parts[1], parts[2]);
            System.out.println("ROGER ROGER Adding the following Clanker.task.Event: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding event: " + task);
        }
    }

    /**
     *  Get all tasks
     */
    public void getTasks() {
        if (index == 0) {
            System.out.println("No tasks found");
        } else {
            System.out.println("ROGER ROGER Here are the tasks: ");
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + tasks[i].toString());
            }
        }
    }
}
