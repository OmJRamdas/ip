package Clanker.exceptions;

public class EmptyDescriptionException extends RuntimeException {
    public EmptyDescriptionException(String message) {
        super("Uh Oh, that " + message  + " doesn't look right");
    }
}
