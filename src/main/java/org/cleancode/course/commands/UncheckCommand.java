package org.cleancode.course.commands;

public class UncheckCommand implements Command {

    private String parameters;

    public UncheckCommand(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {

    }
}
