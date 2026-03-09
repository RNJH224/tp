package seedu.duke.command;

import seedu.duke.module.ModuleList;

public class ListIncompleteCommand extends Command {

    @Override
    public String execute(ModuleList modules) {
        return modules.listIncompleteModules();
    }

}
