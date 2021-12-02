package org.cleancode.course.commands;

import org.cleancode.course.CommandException;
import org.cleancode.course.model.Project;
import org.cleancode.course.model.ProjectList;
import org.cleancode.course.model.Task;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command {

    private String parameters;
    private ProjectList projectList;

    public AddCommand(String parameters, ProjectList projectList) {
        this.parameters = parameters;
        this.projectList = projectList;
    }

    @Override
    public void execute() throws CommandException {
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
        var project = new Project();
        project.setName(name);
        projectList.getProjects().add(project);
    }

    private void addTask(String projectName, String description) throws CommandException {
        var project = projectList.findProjectByName(projectName);
        if (project == null) {
            throw new CommandException("Could not find a project with the name " + projectName);
        }
        project.getTasks().add(new Task(ProjectList.nextId(), description, false));
    }
}
