package seedu.duke.appstate;

import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;
import seedu.duke.profile.UserProfile;
import seedu.duke.storage.PlannerStorage;

public class AppState {
    private ModuleList module;
    private PlannerList planner;
    private UserProfile profile;
    private PlannerStorage plannerStorage;

    public AppState(ModuleList module, PlannerList planner, UserProfile profile,String username) {
        this.module = module;
        this.planner = planner;
        this.profile = profile;
        this.plannerStorage = new PlannerStorage(username);
    }

    public void setPlanner(PlannerList planner) {
        this.planner = planner;
    }

    public ModuleList getModule() {
        return module;
    }

    public PlannerList getPlanner() {
        return planner;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public PlannerStorage getPlannerStorage() {
        return plannerStorage;
    }

    public void update(ModuleList module, PlannerList planner, UserProfile profile, PlannerStorage plannerStorage) {
        this.module = module;
        this.planner = planner;
        this.profile = profile;
        this.plannerStorage = plannerStorage;
    }
}
