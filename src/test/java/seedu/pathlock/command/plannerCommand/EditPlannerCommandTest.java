package seedu.pathlock.command.plannerCommand;

import org.junit.jupiter.api.Test;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.plannercommand.AddToPlannerCommand;
import seedu.pathlock.command.plannercommand.EditPlannerCommand;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;
import seedu.pathlock.storage.PlannerStorage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditPlannerCommandTest {

    private AppState createState(ModuleList modules, PlannerList planner) {
        return new AppState(
                modules,
                planner,
                new UserProfile("Test User", 3.50),
                new PlannerStorage("Test User", "plan1")
        );
    }

    @Test
    public void execute_moduleHasNotBeenAdded_returnsErrorMessage() {
        AppState state = createState(new ModuleList(), new PlannerList());

        EditPlannerCommand command = new EditPlannerCommand("CS1231", "y2s1");
        String result = command.execute(state);

        assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void execute_wrongSemester_returnsErrorMessage() {
        PlannerList planner = new PlannerList();
        AppState state = createState(new ModuleList(), planner);

        new AddToPlannerCommand("CS1231", "y1s1").execute(state);

        EditPlannerCommand command = new EditPlannerCommand("CS1231", "wrongSem");
        String result = command.execute(state);

        assertTrue(result != null && !result.isEmpty());
    }
}
