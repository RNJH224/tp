package seedu.pathlock.command.plannercommand;

import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.Command;
import seedu.pathlock.planner.PlannerList;

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
