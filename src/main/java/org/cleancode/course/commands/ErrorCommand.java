package org.cleancode.course.commands;

public class ErrorCommand implements Command {

    private String command;

    public ErrorCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {

    }
}
