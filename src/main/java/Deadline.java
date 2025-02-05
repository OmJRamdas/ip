public class Deadline extends Task {
    protected String Deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.Deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", getStatus(), this.name, this.Deadline);
    }
}
