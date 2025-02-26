package Clanker.task;

import Clanker.parser.dateTimeParser;

public class Deadline extends Task {
    protected String Deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.Deadline = dateTimeParser.parseDateTime(deadline);
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", getStatus(), this.name, this.Deadline);
    }
}
