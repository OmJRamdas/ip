public class Tasks {
    private String[] tasks;
    private int index;

    public Tasks() {
        tasks = new String[100];
        index = 0;
    }

    public void addTask(String task) {
        tasks[index] = task;
        index++;
        System.out.println("added " + task);
    }

    public void getTasks() {
        if (index == 0) {
            System.out.println("No tasks found");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }
}
