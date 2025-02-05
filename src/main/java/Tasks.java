public class Tasks {
    private Task[] tasks;
    private int index;

    public Tasks() {
        tasks = new Task[100];
        index = 0;
    }

    public void addTask(String task) {
        tasks[index] = new Task(task);
        index++;
        System.out.println("added " + task);
    }

    public void getTasks() {
        if (index == 0) {
            System.out.println("No tasks found");
        } else {
            System.out.println("Here are the tasks: ");
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + tasks[i].getTask());
            }
        }
    }

    public void markTask(int number) {
        tasks[number].markAsDone();
        System.out.println("Yay! This task has been marked as done");
        System.out.println(tasks[number].getTask());
    }

    public void unmarkTask(int number) {
        tasks[number].markAsNotDone();
        System.out.println("Its OK! This task has been marked as not done");
        System.out.println(tasks[number].getTask());
    }
}
