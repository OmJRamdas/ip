public class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getStatus() {
        return (this.isDone) ? "X" : " ";
    }

    public String toString() {
        return String.format("[%s] %s", getStatus(), this.name);
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }
}
