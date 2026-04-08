package seedu.pathlock.command.plannercommand;

import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.Command;
import seedu.pathlock.planner.PlannerList;

public class PlannerSwitchCommand extends Command {
    private final String plannerName;

    public PlannerSwitchCommand(String plannerName) {
        this.plannerName = plannerName;
    }

    @Override
    public String execute(AppState appState) {
        try {
            String username = appState.getProfile().getName();
            appState.switchPlanner(username, plannerName);

            PlannerList loadedPlanner = appState.getPlannerStorage().load();
            appState.setPlanner(loadedPlanner);

            return "Switched to planner: " + plannerName;
        } catch (Exception e) {
            return "Failed to switch planner: " + e.getMessage();
        }
    }
}
