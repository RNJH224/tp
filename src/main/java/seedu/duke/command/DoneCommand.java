package seedu.duke.command;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.exception.DuplicateException;
import seedu.duke.storage.Storage;
import seedu.duke.appstate.AppState;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoneCommand extends Command {
    Storage storage = new Storage("data/test.txt");
    private final String moduleCode;
    private final Logger logger = Logger.getLogger(DoneCommand.class.getName());

    public DoneCommand(String moduleCode) {
        this.moduleCode = moduleCode.toUpperCase();
    }

    @Override
    public String execute(AppState appState) {
        assert appState != null : "AppState should not be null";

        ModuleList modules = appState.getModule();
        String username = appState.getProfile().getName();
        Storage storage = new Storage(username);

        assert modules != null : "ModuleList should not be null";
        assert moduleCode != null && !moduleCode.isEmpty() : "ModuleCode should not be null";

        logger.log(Level.FINE, "Executing DoneCommand for {0}", moduleCode);

        try {
            int modularCredits = modules.getMcForModule(moduleCode);
            Module newModule = new Module(moduleCode, modularCredits);

            modules.addModule(newModule);
            logger.log(Level.FINE, "Module added: {0} (MC={1})",
                    new Object[]{moduleCode, modularCredits});

            storage.save(modules.getCompletedModules());
            logger.log(Level.FINE, "Storage updated for user {0} after adding module: {1}",
                    new Object[]{username, moduleCode});

            return moduleCode + " has been added";

        } catch (DuplicateException e) {
            logger.log(Level.WARNING, "Duplicate module code: {0}", moduleCode);
            return e.getMessage();

        } catch (IllegalArgumentException e){
            logger.log(Level.WARNING, "Invalid module code: {0}", moduleCode);
            return e.getMessage();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Storage failure", e);
            throw new RuntimeException(e);
        }
    }

}
