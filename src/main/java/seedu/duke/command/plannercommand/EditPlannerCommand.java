package seedu.duke.command.plannercommand;

import seedu.duke.appstate.AppState;
import seedu.duke.command.Command;
import seedu.duke.module.ModuleList;
import seedu.duke.module.Module;
import seedu.duke.planner.PlannerList;

public class EditPlannerCommand extends Command {
    private final String moduleCode;
    private final String semester;

    public EditPlannerCommand(String moduleCode, String semester) {
        this.moduleCode = moduleCode.toUpperCase();
        this.semester = semester;
    }
    public String execute (AppState appState) {
        ModuleList moduleList = appState.getModule();
        PlannerList course = appState.getPlanner();
        Module editedModule = moduleList.getModule(moduleCode);
        if (editedModule == null) {
            return "\"" + moduleCode + "\" is not a recognised module.";
        }

        try {
            course.editModule(editedModule, semester, moduleCode);
            appState.getPlannerStorage().save(course);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Edited " + moduleCode + " to be in " + semester;
    }
}
