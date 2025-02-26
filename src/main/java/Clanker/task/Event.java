package Clanker.task;

public class Event extends Task {
    protected String startTime;
    protected String endTime;

    public Event(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (from: %s to: %s)", getStatus(), this.name, this.startTime, this.endTime);
    }
}
