package seedu.pathlock.command;

import org.junit.jupiter.api.Test;
import seedu.pathlock.appstate.AppState;
import seedu.pathlock.module.ModuleList;
import seedu.pathlock.planner.PlannerList;
import seedu.pathlock.profile.UserProfile;
import seedu.pathlock.storage.PlannerStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveCommandTest {
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
    public void execute_existingModule_removedSuccessfully() {
        ModuleList modules = new ModuleList();
        AppState state = createAppState(modules);

        DoneCommand doneCommand = new DoneCommand("CS1231", mc);
        doneCommand.execute(state);

        RemoveCommand removeCommand = new RemoveCommand("CS1231");
        String result = removeCommand.execute(state);

        assertEquals("CS1231 has been removed", result);
        assertEquals(0, modules.getCompletedModules().size());
    }

    @Test
    public void execute_moduleNotInList_returnsErrorMessage() {
        ModuleList modules = new ModuleList();
        AppState state = createAppState(modules);

        RemoveCommand command = new RemoveCommand("CS1231");
        String result = command.execute(state);

        assertEquals("CS1231 is not in your module list", result);
    }

    @Test
    public void execute_lowercaseInput_convertedToUppercase() {
        ModuleList modules = new ModuleList();
        AppState state = createAppState(modules);

        DoneCommand doneCommand = new DoneCommand("CS1231", mc);
        doneCommand.execute(state);

        RemoveCommand removeCommand = new RemoveCommand("cs1231");
        String result = removeCommand.execute(state);

        assertEquals("CS1231 has been removed", result);
    }
}
