package seedu.pathlock.command.plannerCommand;

import org.junit.jupiter.api.Test;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.plannercommand.AddToPlannerCommand;
import seedu.pathlock.command.plannercommand.RemoveFromPlannerCommand;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;
import seedu.pathlock.storage.PlannerStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveFromPlannerCommandTest {

    private AppState createState() {
        return new AppState(
                new ModuleList(),
                new PlannerList(),
                new UserProfile("Test User", 3.50),
                new PlannerStorage("Test User", "plan1")
        );
    }

    @Test
    public void execute_moduleIsThere_success() {
        AppState state = createState();

        new AddToPlannerCommand("CS1231", "y1s1").execute(state);

        RemoveFromPlannerCommand command = new RemoveFromPlannerCommand("CS1231");
        String result = command.execute(state);

        assertEquals("CS1231 has been removed from planner", result);
    }

    @Test
    public void execute_moduleIsNotThere_returnsErrorMessage() {
        AppState state = createState();

        RemoveFromPlannerCommand command = new RemoveFromPlannerCommand("CS1231");
        String result = command.execute(state);

        assertTrue(result != null && !result.isEmpty());
    }
}
