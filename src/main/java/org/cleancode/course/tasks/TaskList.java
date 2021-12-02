package org.cleancode.course.tasks;

import org.cleancode.course.CommandException;
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

    private ProjectList projectList = new ProjectList();
    private final Keyboard keyboard;
    private final Screen screen;

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
        try {
            commandFactory
                    .make(command, commandLine.getRestOfParameters(), projectList, screen)
                    .execute();
        }catch (CommandException ex) {
            screen.printLine(ex.getMessage());
            screen.printLine();
        }
    }
}
