package org.cleancode.course.commands;

import org.cleancode.course.CommandException;
import org.cleancode.course.model.Project;
import org.cleancode.course.model.ProjectList;
import org.cleancode.course.model.Task;

public class UncheckCommand implements Command {

    private String parameters;
    private ProjectList projectList;

    public UncheckCommand(String parameters, ProjectList projectList) {

        this.parameters = parameters;
        this.projectList = projectList;
    }

    @Override
    public void execute() throws CommandException {
        int id = Integer.parseInt(parameters);
        for(Project project: projectList.getProjects()) {
            project.getTasks().getTasks()
                    .stream()
                    .filter(task -> task.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new CommandException("Could not find a task with an ID of " + id))
                    .setDone(false);

        }
    }
}
