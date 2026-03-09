package seedu.duke.command;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.exception.DuplicateException;

public class DoneCommand extends Command {

    private final String moduleCode;

    public DoneCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public String execute(ModuleList modules) {
        Module newModule = new Module(moduleCode);
        try {
            modules.addModule(newModule);
            return moduleCode + " has been added";
        } catch (DuplicateException e) {
            return e.getMessage();
        }
    }

}
