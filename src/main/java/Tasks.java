import java.util.Arrays;

public class Tasks {
    private Task[] tasks;
    private int index;

    public Tasks() {
        tasks = new Task[100];
        index = 0;
    }

    private void addTodo(String task) {
        try {
            tasks[index] = new Todo(task);
            System.out.println("ROGER ROGER Adding the following Todo: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error adding " + task);
        }
    }

    private void addDeadline(String task) {
        try {
            String[] parts = task.split("/by ", 2);
            tasks[index] = new Deadline(parts[0], parts[1]);
            System.out.println("ROGER ROGER Adding the following Deadline: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding event: " + task);
        }
    }

    private void addEvent(String task) {
        try {
            String[] parts = task.split("/from | /to ", 3);
            tasks[index] = new Event(parts[0], parts[1], parts[2]);
            System.out.println("ROGER ROGER Adding the following Event: " + tasks[index].toString());
            index++;
            System.out.println("Now you have " + (index) + " tasks in the list");
        } catch (Exception e) {
            System.out.println("Error in adding event: " + task);
        }
    }

    private void getTasks() {
        if (index == 0) {
            System.out.println("No tasks found");
        } else {
            System.out.println("ROGER ROGER Here are the tasks: ");
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + tasks[i].toString());
            }
        }
    }

    private void markTask(int number) {
        try {
            tasks[number].markAsDone();
            System.out.println("ROGER ROGER! This task has been marked as done");
            System.out.println(tasks[number].toString());
        } catch (Exception e) {
            System.out.println("Error in marking task: " + number);
        }
    }

    private void unmarkTask(int number) {
        try {
            tasks[number].markAsNotDone();
            System.out.println("ROGER ROGER! This task has been marked as not done");
            System.out.println(tasks[number].toString());
        } catch (Exception e) {
            System.out.println("Error in unmarking task: " + number);
        }
    }

    public boolean handleCommand(String userCommand) {

        String[] parts = userCommand.split(" ");
        String firstWord = parts[0];
        String remainingWords = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));

        switch (firstWord) {
            case "BLAST-EM":
                return false;
            case "mark":
                this.markTask(Integer.parseInt(parts[1]) - 1);
                return true;
            case "unmark":
                this.unmarkTask(Integer.parseInt(parts[1]) - 1);
                return true;
            case "list":
                getTasks();
                return true;
            case "todo":
                this.addTodo(remainingWords);
                return true;
            case "deadline":
                this.addDeadline(remainingWords);
                return true;
            case "event":
                this.addEvent(remainingWords);
                return true;
            default:
                System.out.println("Unknown command: " + userCommand);
                return true;
        }
    }
}
