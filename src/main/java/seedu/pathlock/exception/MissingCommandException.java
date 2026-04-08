package seedu.pathlock.exception;

public class MissingCommandException extends IllegalArgumentException {
    public MissingCommandException(String message) {
        super(message);
    }
}
