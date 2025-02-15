package Clanker.exceptions;

/**
 *  Command does not have a description
 */
public class EmptyDescriptionException extends RuntimeException {
    public EmptyDescriptionException(String message) {
        super("Uh Oh, that " + message  + " doesn't look right");
    }
}
