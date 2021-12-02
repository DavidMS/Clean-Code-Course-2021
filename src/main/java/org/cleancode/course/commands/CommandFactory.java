package org.cleancode.course.commands;

import org.cleancode.course.io.Screen;
import org.cleancode.course.model.ProjectList;

import static org.cleancode.course.commands.Command.CMD_ADD;
import static org.cleancode.course.commands.Command.CMD_CHECK;
import static org.cleancode.course.commands.Command.CMD_HELP;
import static org.cleancode.course.commands.Command.CMD_QUIT;
import static org.cleancode.course.commands.Command.CMD_SHOW;
import static org.cleancode.course.commands.Command.CMD_UNCHECK;

public class CommandFactory {

    public Command make(String commandType, String parameters, ProjectList projectList, Screen screen) {
        switch (commandType) {
            case CMD_ADD: return new AddCommand(parameters, projectList);
            case CMD_CHECK: return new CheckCommand(parameters, projectList);
            case CMD_HELP: return new HelpCommand(screen);
            case CMD_QUIT: return new QuitCommand();
            case CMD_SHOW: return new ShowCommand(projectList, screen);
            case CMD_UNCHECK: return new UncheckCommand(parameters, projectList);
            default: return new ErrorCommand(commandType, screen);
        }
    }
}
