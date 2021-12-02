package org.cleancode.course.commands;

import org.cleancode.course.CommandException;

public interface Command {

    String CMD_ADD = "add";
    String CMD_SHOW = "show";
    String CMD_QUIT = "quit";
    String CMD_CHECK = "check";
    String CMD_UNCHECK = "uncheck";
    String CMD_HELP = "help";

    void execute() throws CommandException;
}
