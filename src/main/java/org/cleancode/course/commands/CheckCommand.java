package org.cleancode.course.commands;

public class CheckCommand implements Command {

    private String parameters;

    public CheckCommand(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {

    }
}
