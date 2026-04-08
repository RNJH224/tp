package seedu.pathlock.command.plannercommand;

import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.Command;
import seedu.pathlock.planner.PlannerList;

public class ListPlannerCommand extends Command {
    public String execute (AppState appState) {
        PlannerList course = appState.getPlanner();
        return course.list();
    }
}
