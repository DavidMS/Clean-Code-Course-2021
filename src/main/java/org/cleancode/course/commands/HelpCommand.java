package org.cleancode.course.commands;

import org.cleancode.course.io.Screen;

public class HelpCommand implements Command {

    private Screen screen;

    public HelpCommand(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.printLine("Commands:");
        screen.printLine("  show");
        screen.printLine("  add project <project name>");
        screen.printLine("  add task <project name> <task description>");
        screen.printLine("  check <task ID>");
        screen.printLine("  uncheck <task ID>");
        screen.printLine();
    }
}
