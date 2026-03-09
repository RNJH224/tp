package seedu.duke.command;

import seedu.duke.module.ModuleList;

public class ListNeededCommand extends Command {

    @Override
    public String execute(ModuleList modules) {
        return modules.listNeededModules();
    }

}
