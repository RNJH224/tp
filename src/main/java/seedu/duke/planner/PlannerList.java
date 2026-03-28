package seedu.duke.planner;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import seedu.duke.module.Module;
public class PlannerList {
    private ArrayList<ArrayList<Module>> course;

    public PlannerList() {
        course = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            course.add(new ArrayList<Module>());
        }
    }

    public String list () {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            output.append("sem: ");
            output.append(i+1);
            output.append("\n");
            ArrayList<Module> currSem = course.get(i);
            for (Module currModule : currSem) {
                output.append(currModule.getModuleCode());
                output.append("\n");
            }
        }
        return output.toString();
    }

    private boolean isModuleInPlanner (String moduleCode) {
        for (int i = 0; i < 8; i++) {
            ArrayList<Module> currSem = course.get(i);
            for (Module currModule : currSem) {
                if (currModule.getModuleCode().equals(moduleCode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addModule(Module module) {
        String semester = module.getSemester();
        switch(semester) {
        case "y1s1": course.get(0).add(module);
            break;
        case "y1s2": course.get(1).add(module);
            break;
        case "y2s1": course.get(2).add(module);
            break;
        case "y2s2": course.get(3).add(module);
            break;
        case "y3s1": course.get(4).add(module);
            break;
        case "y3s2": course.get(5).add(module);
            break;
        case "y4s1": course.get(6).add(module);
            break;
        case "y4s2": course.get(7).add(module);
            break;
        default:
            break;
        }
    }

    public void removeModule(String moduleCode) {
        boolean isModulePresent = false;
        for (int i = 0; i < 8; i++) {
            ArrayList<Module> currSem = course.get(i);
            for (int j = 0; j < currSem.size(); j++) {
                Module currModule = currSem.get(j);
                if (currModule.getModuleCode().equals(moduleCode)) {
                    currSem.remove(j);
                    isModulePresent = true;
                }
            }
        }
        if (!isModulePresent) {
            throw new NoSuchElementException(moduleCode + " is not found in planner");
        }
    }

    public void editModule(Module editedModule, String semester) {
        editedModule.setSemester(semester);
       String moduleCode = editedModule.getModuleCode();
       removeModule(moduleCode);
       addModule(editedModule);
    }
    // TODO: findModule(), editModule(), removeModule()
}
