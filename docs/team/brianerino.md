# Brian - Project Portfolio Page

## Project: PathLock

PathLock is a desktop CLI application designed to help Computer Engineering (CEG) students at NUS plan and track their multi-year academic journey. It enables students to record completed modules, monitor MC progress towards the 160-MC graduation requirement, check prerequisite and post-requisite chains, and organise planned modules across semesters — all offline, with data stored in a human-editable file.

Given below are my contributions to the project.

- **New Feature**: Added the `list` commands (`list completed`, `list incomplete`, `list needed`)
  - What it does: Gives users three filtered views of their module list. Completed modules, required CEG modules not yet completed (handling OR-group modules), and every required graduation module.
  - Justification: PathLock provides CEG students with a consolidated view of all the modules needed to graduate. This also allows them to track the modules they have/have not done, allowing them to view it all under a single command.
  - Highlights: All three commands follow a thin-wrapper pattern. Each retrieves `ModuleList` from `AppState` and delegates entirely to a single method, keeping command classes minimal and filtering logic centralised.


- **New Feature**: Added the `help` commands (`help`, `help <command>`)
  - What it does: Supports two modes: `help` displays a grouped overview of all available commands. `help <command>` displays detailed usage, examples, and expected output for a specific command.
  - Justification: For ease of knowing the capabilities of PathLock, this command summarises all the available commands as well as provides detailed examples if required. It is the backbone that any user relies on for smooth operation of the app.
  - Highlights: Uses a `LinkedHashMap<String, String>` keyed by normalised topic name with a `normaliseTopic()` method, so adding a new command requires only one map entry.


- **New Feature**: UserProfile & GPA-Based Workload Recommendation
  - What it does: Stores the user's name and GPA, and derives a recommended maximum semester workload from a tiered GPA-to-workload system. Also accounts for y1s1 students starting off their academic journey that do not have a valid GPA yet.
  - Justification: Students planning their semesters have very different capacities depending on their academic standing. A student with a 4.8 GPA taking 32 MCs is very different from a student with a 2.5 GPA attempting the same. This feature gives personalised guidance rather than a one-size-fits-all cap.
  - Highlights: The class enforces input validation at construction time, invalid names or GPAs outside the 2.0–5.0 range throw an `IllegalArgumentException` immediately. For first-semester students with GPA 0.00, the system accepts this and assigns a default maximum of 20 MCs.


- **New Feature**: Implemented the Base Structure of ProfileStorage (Persistent User Profile)
  - What it does: Persists and retrieves the user's profile between sessions. Each user gets a dedicated file at `data/users/<username>_profile.txt` in the format `NAME|GPA`.
  - Justification: Returning users should never have to re-enter their GPA. On app launch, PathLock checks for a saved profile. If found, it loads it directly and greets the user. If not, it prompts for a GPA and saves the new profile.


- **New Feature**: Semester Workload Warnings in `planner add`
  - What it does: Extended `AddToPlannerCommand` to check the user's planned workload against their GPA-based recommended maximum and a fixed minimum of 18 MCs, displaying targeted warnings after every `planner add` call. The module is always added, warnings inform rather than block.
  - Justification: Not knowing the maximum or minimum workload that a student can take in a semester is one of the most common planning mistakes for CEG students. Surfacing this in real time, personalised to the user's GPA, allows them to know exactly how many modules they can take in the semester.


- **Code contributed**: [Brian's tP RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=brianerino&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)


- **Enhancements to existing features**:
  - Updated `HelpCommand` consistently throughout the project to reflect new commands added by teammates (Pull requests [#142](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/142), [#134](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/134))
  - Fixed `UserProfile` to reject `NaN` as a GPA input, which previously passed validation silently (Pull request [#232](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/232))
  - Added assertions and logging to `list` commands for better error visibility (Pull request [#45](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/45))
  - Updated `EXPECTED.TXT` to match new PathLock output for Java CI
  - Added JUnit tests for `ListCompleted`, `ListIncomplete`, `ListNeeded` commands (Pull request [#39](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/39))
  - Added JUnit tests for `HelpCommand` (Pull request [#75](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/75))
  - Added JUnit tests for `UserProfile` and `ProfileStorage` (Pull request [#140](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/140))
  - Extended `ParserTest` and `CountCommandTest` with additional test cases 


- **Project management**:
  - Set up the initial project structure by adding the basic Start-Interface and Parser for testing
  - Created and maintained issue labels on GitHub to categorise tasks (e.g. bug, enhancement, type) for better tracking across the team
  - Set deadlines for milestone targets to keep the team on schedule throughout the project


- **Documentation**:
  - User Guide:
    - Wrote a skeleton of the User Guide including Table of Contents, Quick Start, FAQ, Known Issues, and Command Summary. (Pull request [#87](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/87))
    - Wrote the PathLock System Commands section: `help` (both modes with example outputs), `exit`, `switch`, and all three `list` commands with usage format and example outputs.
  - Developer Guide:
    - Formatted the entire DG and produced the Table of Contents. (Pull request [#145](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/145))
    - Wrote the Planned Enhancements (V3) section, recognising current constraints and limitations that can be improved on for a later version. (Pull request [#248](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/248))
    - Wrote the `Command.java` API section with explanation, class diagram, and sequence diagrams for general command flow. (Pull request [#146](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/146))
    - Wrote the `list` commands implementation section: design pipeline, parsing walkthrough, class diagram, and sequence diagrams for all three commands. (Pull request [#90](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/90))
    - Wrote the `help` command implementation section: design pipeline, walkthrough, class diagram, sequence diagrams, and rationale for the design. (Pull request [#90](https://github.com/AY2526S2-CS2113-F14-3/tp/pull/90))
    - Wrote the `UserProfile` and `ProfileStorage` implementation section: design pipeline, load/save flows, workload logic, class diagrams, and sequence diagrams.


- **Community**:
  - Maintained and updated `HelpCommand` to stay in sync with new commands added by teammates throughout the project.
  - Updated the User/Developer Guide structure to ensure consistent section formatting across all team members' contributions.
  - Helped teammates fix Checkstyle or code errors during Java CI checks, edited `EXPECTED.txt` to fit new implementations.
  - Renamed files and reviewed comments for teammates, provided design input during group meetings.
  - Changed logo to ASCII characters for Java CI compatibility 
  - Fixed Gradle main application build path 

  




