package org.cleancode.course.tasks;

import org.cleancode.course.commands.CommandFactory;
import org.cleancode.course.commands.CommandLine;
import org.cleancode.course.io.Keyboard;
import org.cleancode.course.io.Screen;
import org.cleancode.course.model.Project;
import org.cleancode.course.model.ProjectList;
import org.cleancode.course.model.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private ProjectList projectList = new ProjectList();
    private final Keyboard keyboard;
    private final Screen screen;

    private long lastId = 0;

    public static void main(String ...args) throws Exception {
        Keyboard keyboard = new Keyboard();
        Screen screen = new Screen();
        new TaskList(keyboard, screen).run();
    }

    public TaskList(Keyboard keyboard, Screen screen) {
        this.keyboard = keyboard;
        this.screen = screen;
    }

    public void run() {
        while (true) {
            screen.print("> ");
            String command;
            try {
                command = keyboard.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLineString) {
        CommandLine commandLine = new CommandLine(commandLineString);
        String command = commandLine.extractCommand();
        CommandFactory commandFactory = new CommandFactory();
        switch (command) {
            case "show":
                commandFactory
                        .make(command, commandLine.getRestOfParameters(), projectList, screen)
                        .execute();
                break;
            case "add":
                add(commandLine.getRestOfParameters());
                break;
            case "check":
                check(commandLine.getRestOfParameters());
                break;
            case "uncheck":
                uncheck(commandLine.getRestOfParameters());
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
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

    private void addTask(String projectName, String description) {
        List<Task> projectTasks = tasks.get(projectName);
        var project = projectList.findProjectByName(projectName);
        if (project == null) {
            screen.printFormat("Could not find a project with the name \"%s\".", projectName);
            screen.printLine();
            return;
        }
        project.getTasks().add(new Task(nextId(), description, false));
    }

    private void check(String idString) {
        setDone(idString, true);
    }

    private void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Project project : projectList.getProjects()) {
            for (Task task : project.getTasks().getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        screen.printFormat("Could not find a task with an ID of %d.", id);
        screen.printLine();
    }

    private void help() {
        screen.printLine("Commands:");
        screen.printLine("  show");
        screen.printLine("  add project <project name>");
        screen.printLine("  add task <project name> <task description>");
        screen.printLine("  check <task ID>");
        screen.printLine("  uncheck <task ID>");
        screen.printLine();

    }

    private void error(String command) {
        screen.printFormat("I don't know what the command \"%s\" is.", command);
        screen.printLine();
    }

    private long nextId() {
        return ++lastId;
    }
}
