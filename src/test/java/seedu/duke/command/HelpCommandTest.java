package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.module.ModuleList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelpCommandTest {
    @Test
    public void execute_generalHelp_returnsGroupedCommandList() {
        ModuleList modules = new ModuleList();
        HelpCommand command = new HelpCommand();
        String result = command.execute(modules);
        assertTrue(result.contains("PATHLOCK HELP"));
        assertTrue(result.contains("LIST COMMANDS"));
        assertTrue(result.contains("MODULE MANAGEMENT COMMANDS"));
        assertTrue(result.contains("SYSTEM COMMANDS"));
        assertTrue(result.contains("list completed"));
        assertTrue(result.contains("done MODULE_CODE"));
        assertTrue(result.contains("remove MODULE_CODE"));
        assertTrue(result.contains("help"));
        assertTrue(result.contains("exit"));
    }

    @Test
    public void execute_helpDone_returnsDetailedHelpForDone() {
        ModuleList modules = new ModuleList();
        HelpCommand command = new HelpCommand("done");
        String result = command.execute(modules);
        assertTrue(result.contains("COMMAND: done"));
        assertTrue(result.contains("Marks a module as completed"));
        assertTrue(result.contains("done MODULE_CODE"));
        assertTrue(result.contains("done MODULE_CODE /mc NUMBER"));
        assertTrue(result.contains("done CS2113"));
    }

    @Test
    public void execute_helpListCompleted_returnsDetailedHelpForListCompleted() {
        ModuleList modules = new ModuleList();
        HelpCommand command = new HelpCommand("list completed");
        String result = command.execute(modules);
        assertTrue(result.contains("COMMAND: list completed"));
        assertTrue(result.contains("Shows all modules you have completed"));
        assertTrue(result.contains("list completed"));
    }

    @Test
    public void execute_helpUnknownTopic_returnsNotFoundMessage() {
        ModuleList modules = new ModuleList();
        HelpCommand command = new HelpCommand("nonsense");
        String result = command.execute(modules);
        assertTrue(result.contains("No detailed help found"));
        assertTrue(result.contains("nonsense"));
        assertTrue(result.contains("Type 'help' to see all available commands"));
    }

    @Test
    public void execute_helpTopicWithExtraSpaces_returnsCorrectDetailedHelp() {
        ModuleList modules = new ModuleList();
        HelpCommand command = new HelpCommand("   done   ");
        String result = command.execute(modules);
        assertTrue(result.contains("COMMAND: done"));
        assertTrue(result.contains("done MODULE_CODE"));
    }
}
