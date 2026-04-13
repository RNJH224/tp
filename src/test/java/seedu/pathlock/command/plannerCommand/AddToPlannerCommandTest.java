package seedu.pathlock.command.plannerCommand;

import org.junit.jupiter.api.Test;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.command.plannercommand.AddToPlannerCommand;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;
import seedu.pathlock.storage.PlannerStorage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToPlannerCommandTest {

    private AppState createState(ModuleList modules, PlannerList planner) {
        return new AppState(
                modules,
                planner,
                new UserProfile("Test User", 3.50),
                new PlannerStorage("Test User", "plan1")
        );
    }

    @Test
    public void execute_moduleCodeDoesNotExist_throwsException() {
        AppState state = createState(new ModuleList(), new PlannerList());

        AddToPlannerCommand command = new AddToPlannerCommand("CS9999", "y1s1");

        assertThrows(IllegalArgumentException.class, () -> command.execute(state));
    }

    @Test
    public void execute_moduleCodeDoesExist_success() {
        AppState state = createState(new ModuleList(), new PlannerList());

        AddToPlannerCommand command = new AddToPlannerCommand("CS1231", "y1s1");
        String result = command.execute(state);

        assertTrue(result.startsWith("Module CS1231 added to y1s1."));
    }

    @Test
    public void execute_semesterWrongFormat_returnsErrorMessage() {
        AppState state = createState(new ModuleList(), new PlannerList());

        AddToPlannerCommand command = new AddToPlannerCommand("CS1231", "wrongSem");
        String result = command.execute(state);

        assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void execute_semesterRightFormat_success() {
        AppState state = createState(new ModuleList(), new PlannerList());

        AddToPlannerCommand command = new AddToPlannerCommand("CS1231", "y1s1");
        String result = command.execute(state);

        assertTrue(result.startsWith("Module CS1231 added to y1s1."));
    }

    @Test
    public void execute_moduleAlreadyAdded_throwsException() {
        PlannerList planner = new PlannerList();
        AppState state = createState(new ModuleList(), planner);

        new AddToPlannerCommand("CS1231", "y1s1").execute(state);

        AddToPlannerCommand secondCommand = new AddToPlannerCommand("CS1231", "y1s1");

        assertThrows(IllegalArgumentException.class, () -> secondCommand.execute(state));
    }
}
