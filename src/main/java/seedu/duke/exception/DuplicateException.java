package seedu.duke.exception;

public class DuplicateException extends Exception {

    public DuplicateException(String moduleCode) {
        super("Module" + moduleCode + " has already been completed");
    }
}
