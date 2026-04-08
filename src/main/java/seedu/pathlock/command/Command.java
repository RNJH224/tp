package seedu.pathlock.command;

import seedu.pathlock.appstate.AppState;

public abstract class Command {
    public abstract String execute(AppState appState);
}
