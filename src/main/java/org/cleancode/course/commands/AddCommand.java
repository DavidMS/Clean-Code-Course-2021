package org.cleancode.course.commands;

import org.cleancode.course.model.Task;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command {

    private String parameters;

    public AddCommand(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        String[] subcommandRest = parameters.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {

    }

    private void addTask(String project, String description) {
    }
}
