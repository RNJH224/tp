package seedu.pathlock.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.exception.DuplicateException;
import seedu.pathlock.module.Module;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;

public class ListCompletedCommandTest {
    @Test
    public void execute_noCompletedModules_returnsEmptyMessage() {
        AppState state = new AppState(
                new ModuleList(),
                new PlannerList(),
                new UserProfile("Test User", 3.50),
                "Test User"
        );
        ListCompletedCommand command = new ListCompletedCommand();
        String result = command.execute(state);
        assertEquals("No modules completed yet.", result);
    }

    @Test
    public void execute_withCompletedModules_returnsCompletedList() throws DuplicateException {
        ModuleList modules = new ModuleList();
        modules.addModule(new Module("CS2113",4));
        modules.addModule(new Module("CS1231",4));
        AppState state = new AppState(
                modules,
                new PlannerList(),
                new UserProfile("Test User", 3.50),
                "Test User"
        );
        ListCompletedCommand command = new ListCompletedCommand();
        String result = command.execute(state);
        assertTrue(result.contains("CS2113"));
        assertTrue(result.contains("CS1231"));
    }
}
