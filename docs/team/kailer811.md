# Kai Ler - Project Portfolio Page

## Overview

PathLock is a desktop CLI application designed to help Computer Engineering (CEG) students at NUS plan and track
their multi-year academic journey. It enables students to record completed modules, monitor MC progress towards the
160-MC graduation requirement, check prerequisite and post-requisite chains, and organise planned modules across
semesters — all offline, with data stored in a human-editable file.

Given below are my contributions to the project.

---

- **New Feature**: Initial UI
  - What it does: provides Users with clear visual feedback on commands they have inputted 
  - Justification
    - User needs confirmation that what Pathlock has completed is what the User intends 
    - Clearly distinguish between Users' inputs and Pathlock's output
    - Echoes with details on command executed and params taken in by Pathlock
  -  Highlights
    - Opening message and intro of Pathlock with prompt on `help` command
    - Users' inputs are indicated by `Pathlock awaits: `
    - Inputs and outputs separated by dashes
-  **New Feature**: Planner and its commands (`planner add`, `planner remove`, `planner edit`, `planner list`)
  - What it does: allows the user to add, remove, edit, module to a planner. Planner can then be displayed showing the modules and the semesters they are planned for
  - Justification: Allows User's to plan ahead of time what modules they would like to take and the flexibility to change it easily
  - Highlights
    - non caps sensitive, allowing user to type commands faster without having to worry about caps
 **Enhancements to existing features**:
    - ensured overall UI is generally standardised, all to have opening and closing dashes
    - restructured Command Abstract type to take in AppState, rather than ModuleList to allow for addition of Planner Commands and easier addition of subsequent features

---

- **Code contributed**
  [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=Kailer811&tabRepo=AY2526S2-CS2113-F14-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

---

- **Project management**:
  - set up the initial organisation and forked repo from the main CS2113/tp

---

- **Documentation**: 
  - User Guide:
    - Added documentation for all `planner` commands with expected output
  -  Developer Guide:
    - Added implementation sections for `planner` commands
    - Added sequence diagrams and UML for `planner` commands
    - Added a couple User Stories

---

- **Community**:
  - Reviewed groupmates UML and sequence diagrams
