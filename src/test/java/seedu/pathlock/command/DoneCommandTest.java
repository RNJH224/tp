package seedu.pathlock.command;

import org.junit.jupiter.api.Test;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;
import seedu.pathlock.storage.PlannerStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoneCommandTest {
    private final int mc = 4;

    private AppState createAppState(ModuleList modules) {
        return new AppState(
                modules,
                new PlannerList(),
                new UserProfile("Test User", 3.50),
                new PlannerStorage("Test User", "plan1")
        );
    }

    @Test
    public void execute_validModule_success() {
        ModuleList modules = new ModuleList();
        AppState state = createAppState(modules);

        DoneCommand command = new DoneCommand("CS1231", mc);
        String result = command.execute(state);

        assertEquals("CS1231 has been added.", result);
        assertEquals(1, modules.getCompletedModules().size());
    }

    @Test
    public void execute_lowercaseInput_convertedToUppercase() {
        ModuleList modules = new ModuleList();
        AppState state = createAppState(modules);

        DoneCommand command = new DoneCommand("cs1231", mc);
        String result = command.execute(state);

        assertEquals("CS1231 has been added.", result);
    }
}
