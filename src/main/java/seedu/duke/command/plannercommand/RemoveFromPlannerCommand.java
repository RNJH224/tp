package seedu.duke.command.plannercommand;

import seedu.duke.appstate.AppState;
import seedu.duke.command.Command;
import seedu.duke.planner.PlannerList;

public class RemoveFromPlannerCommand extends Command {
    private final String moduleCode;

    public RemoveFromPlannerCommand(String moduleCode) {
        this.moduleCode = moduleCode.toUpperCase();
    }

    public String execute (AppState appState) {
        PlannerList course = appState.getPlanner();
        try {
            course.removeModule(moduleCode);
            appState.getPlannerStorage().save(course);
        } catch (Exception e) {
            return e.getMessage();
        }
        return moduleCode + " has been removed from planner";
    }
}
