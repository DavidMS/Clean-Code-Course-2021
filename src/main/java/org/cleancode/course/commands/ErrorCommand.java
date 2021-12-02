package org.cleancode.course.commands;

import org.cleancode.course.io.Screen;

public class ErrorCommand implements Command {

    private String command;
    private Screen screen;

    public ErrorCommand(String command, Screen screen) {
        this.command = command;
        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.printFormat("I don't know what the command \"%s\" is.", command);
        screen.printLine();
    }
}
