package Clanker.exceptions;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message) {
        super("Uh Oh, unknown command: " + message);
    }
}
