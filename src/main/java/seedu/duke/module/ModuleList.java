package seedu.duke.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import seedu.duke.exception.DuplicateException;

public class ModuleList {

    private static final List<String> REQUIRED_MODULES = Arrays.asList(
            // common curriculum requirements
            "CDE2501", "GEC", "GEN", "ES2631", "CS1010", "GEA1000", "DTK1234", "EG1311", "EE2211", "PF1101",

            // major requirements - engineering core
            "MA1511", "MA1512", "MA1508E", "EG2401A", "CP3880", "EG3611A",

            // CEG discipline core
            "CG1111A", "CG2111A", "CS1231", "CG2023", "CG2027", "CG2028", "CG2271", "CG3201", "CG3207", "CS2040C",
            "CS2107", "CS2113", "EE2026", "EE4204", "CG4002",

            // unrestricted electives placeholders
            "UE1", "UE2", "UE3", "UE4", "UE5", "UE6", "UE7", "UE8", "UE9", "UE10"
    );

    private final List<Module> completedModules;

    public ModuleList(List<Module> completedModules) {
        this.completedModules = completedModules;
    }

    public void addModule(Module newModule) throws DuplicateException {
        for (Module module : completedModules) {
            if (module.getModuleCode().equals(newModule.getModuleCode())) {
                throw new DuplicateException(newModule.getModuleCode());
            }
        }
        newModule.markCompleted();
        completedModules.add(newModule);
    }


    public boolean removeModule(String moduleCode) {
        for (int i = 0; i < completedModules.size(); i++) {
            Module module = completedModules.get(i);
            if (module.getModuleCode().equalsIgnoreCase(moduleCode)) {
                module.markIncompleted();
                completedModules.remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean isInCompletedList(String moduleCode) {
        for (Module module : completedModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                return true;
            }
        }
        return false;
    }

    public String listCompletedModules() {
        if (completedModules.isEmpty()) {
            return "No modules completed yet.";
        }

        StringBuilder completedModulesList = new StringBuilder("Completed modules:\n");
        for (int i = 0; i < completedModules.size(); i++) {
            completedModulesList.append(i + 1)
                    .append(". ")
                    .append(completedModules.get(i).getModuleCode())
                    .append("\n");
        }
        return completedModulesList.toString().trim();
    }

    public String listNeededModules() {
        StringBuilder neededModulesList = new StringBuilder("Modules required for graduation:\n");
        for (int i = 0; i < REQUIRED_MODULES.size(); i++) {
            neededModulesList.append(i + 1)
                    .append(". ")
                    .append(REQUIRED_MODULES.get(i))
                    .append("\n");
        }
        return neededModulesList.toString().trim();
    }

    public String listIncompleteModules() {
        List<String> incompleteModules = new ArrayList<>();

        for (String requiredModule : REQUIRED_MODULES) {
            if (!isInCompletedList(requiredModule)) {
                incompleteModules.add(requiredModule);
            }
        }

        if (incompleteModules.isEmpty()) {
            return "All required modules have been completed.";
        }

        StringBuilder incompleteModulesList = new StringBuilder("Incomplete modules:\n");
        for (int i = 0; i < incompleteModules.size(); i++) {
            incompleteModulesList.append(i + 1)
                    .append(". ")
                    .append(incompleteModules.get(i))
                    .append("\n");
        }
        return incompleteModulesList.toString().trim();
    }


}
