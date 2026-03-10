package seedu.duke.module;

public class Module {
    private final String moduleCode;
    private final int modularCredits;
    private boolean isCompleted;

    public Module(String moduleCode, int modularCredits) {
        this.moduleCode = moduleCode;
        this.modularCredits = modularCredits;
        this.isCompleted = false;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getModularCredits() {
        return modularCredits;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public void markIncompleted() {
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return moduleCode;
    }

}
