# Pathlock User Guide

PathLock is a **desktop app for planning your CEG modules**, optimised for use via a **Command Line Interface (CLI)**. If you can type fast, PathLock can help you track completed modules, plan future semesters, and monitor your MC progress faster than traditional planners. The app works fully offline, and stores plans in a human-editable file for flexible iteration.

## Table of Contents

- [Quick Start](#quick-start)
- [Features](#features)
    - [Viewing help: `help`](#viewing-help--help)
    - [Marking a module as completed: `done`](#marking-a-module-as-completed--done)
    - [Removing a completed module: `remove`](#removing-a-completed-module--remove)
    - [Listing completed modules: `list completed`](#listing-completed-modules--list-completed)
    - [Listing incomplete modules: `list incomplete`](#listing-incomplete-modules--list-incomplete)
    - [Listing all required modules: `list needed`](#listing-all-required-modules--list-needed)
    - [Counting MC progress: `count`](#counting-mc-progress--count)
    - [Adding a module to your planner: `planner add MODULE_CODE y#s#`](#adding-a-module-to-your-planner--planner-add)
    - [Removing a module from your planner: `planner remove MODULE_CODE`](#removing-a-module-from-your-planner--planner-remove)
    - [Shifting a module to another semester on your planner: `planner edit MODULE_CODE y#s#`](#shifting-a-module-on-your-planner--planner-edit)
    - [Viewing your planner: `planner list`](#viewing-your-planner--planner)
    - [Saving your data](#saving-your-data)
    - [Exiting the program: `exit`](#exiting-the-program--exit)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)

---

## Quick Start

1. Ensure you have **Java 17** or above installed on your computer.

2. Download the latest `pathlock.jar` from the releases page.

3. Copy the file to the folder you want to use as the **home folder** for PathLock.

4. Open a command terminal, `cd` into the folder you placed the jar file in, and run:
   ```
   java -jar pathlock.jar
   ```

5. On first launch, PathLock will ask for your **name** and **GPA (2.0–5.0)**. This is used to recommend a maximum semester workload.

6. Type a command and press **Enter** to execute it. Some commands you can try:
  - `list needed` — Lists all modules required for graduation
  - `done CS1010` — Marks CS1010 as completed
  - `count` — Shows your MC progress
  - `help` — Shows all available commands
  - `exit` — Exits the app

7. Refer to the [Features](#features) section below for details on each command.

---

## Features 

> **Notes:**
> - Words in `UPPER_CASE` are parameters to be supplied by you. e.g. in `done MODULE_CODE`, `MODULE_CODE` is a parameter such as `done CS2113`.
> - Module codes must follow the NUS format: 2–3 uppercase letters, 4 digits, and an optional trailing letter (e.g. `CS2040C`, `EE2026`).
> - Commands are **case-insensitive** for module codes (e.g. `done cs2113` works the same as `done CS2113`).

---
### PathLock System Commands

#### Viewing help : `help`

Shows a grouped overview of all commands, or detailed help for a specific command.

**Format:** `help` or `help COMMAND`

**Examples:**
- `help` — shows all commands
- `help done` — shows detailed help for the `done` command
- `help list completed` — shows detailed help for `list completed`

**Example output (help done):**
```
=======================================================================
COMMAND: done
=======================================================================
Purpose:
  Marks a module as completed.

Usage:
  done MODULE_CODE
  done MODULE_CODE /mc NUMBER

Examples:
  done CS2113
  done SEP101 /mc 4
=======================================================================
```

---
### List Commands

#### Listing completed modules : `list completed`

Shows all modules you have marked as completed.

**Format:** `list completed`

**Example output:**
```
Completed modules:
1. CS1010
2. CS2113
3. CG2111A
```

#### Listing incomplete modules : `list incomplete`

Shows all required CEG modules that you have not yet completed.

**Format:** `list incomplete`

**Example output:**
```
Incomplete modules:
1. CS2040C
2. EE2026
3. CS2103 OR CS2113
```

#### Listing all required modules : `list needed`

Shows the full list of modules required to graduate from CEG.

**Format:** `list needed`

**Example output:**
```
Modules required for graduation:
1. CS1010
2. CS2040C
3. CS2103 OR CS2113
4. CG2111A
...
```

---
### Module Management Commands

#### Counting MC progress : `count`

Shows your completed and remaining MC progress towards the 160 MCs required for graduation.

**Format:** `count`

**Example output:**
```
Completed: 40 / 160 MCs (25.0%)
Incomplete: 120 MCs (75.0%)
```

---
### Module Planner Commands

#### Adding a module to your planner : `planner add MODULE_CODE y#s#`


---

## FAQ

**Q: How do I transfer my data to another computer?**  
**A**: Copy the entire `data/` folder from your current computer to the same location on the new computer (the folder where `pathlock.jar` is).

**Q: Can I edit the plan file directly?**  
**A**: Yes. The plan file is human-editable. However, if the format is modified incorrectly, Path Lock may fail to load the file or may reset the data.

**Q: Can I add modules that are not in the CEG required list?**  
**A**: Yes. Use `done MODULE_CODE /mc NUMBER` to add external or SEP modules with a custom MC value.

**Q: Is Path Lock case-sensitive?**  
**A**: No. Module codes are case-insensitive.

**Q: Can I use Path Lock without internet access?**  
**A**: Yes. Path Lock runs fully offline and does not require internet connectivity.

---
## Known Issues

1. **Profile is loaded from `data/profile.txt`** — If this file is deleted or corrupted, PathLock will prompt you to create a new profile on the next run.

---
## Command Summary
| Action | Format                         | Example                   |
|---|--------------------------------|---------------------------|
| View all commands | `help`                         | `help`                    |
| View command details | `help COMMAND`                 | `help done`               |
| Mark module as done | `done MODULE_CODE`             | `done CS2113`             |
| Add external module | `done MODULE_CODE /mc NUMBER`  | `done SEP101 /mc 4`       |
| Remove a module | `remove MODULE_CODE`           | `remove CS2113`           |
| List completed modules | `list completed`               | `list completed`          |
| List incomplete modules | `list incomplete`              | `list incomplete`         |
| List all required modules | `list needed`                  | `list needed`             |
| Count MC progress | `count`                        | `count`                   |
| Add module to planner | `planner add MODULE_CODE y#s#` | `planner add CS1010 y1s1` |
| View planner | `planner list`                 | `planner list`            |
| Exit PathLock | `exit`                         | `exit`                    |

