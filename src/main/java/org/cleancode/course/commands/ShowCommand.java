package org.cleancode.course.commands;

import org.cleancode.course.io.Screen;
import org.cleancode.course.model.Project;
import org.cleancode.course.model.ProjectList;
import org.cleancode.course.model.Task;

public class ShowCommand implements Command {

    private ProjectList projectList;
    private Screen screen;

    public ShowCommand(ProjectList projectList, Screen screen) {
        this.projectList = projectList;
        this.screen = screen;
    }

    @Override
    public void execute() {
        for (Project project : projectList.getProjects()) {
            screen.printLine(project.getName());
            for (Task task : project.getTasks().getTasks()) {
                screen.printFormat("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            screen.printLine();
        }
    }
}
