package org.cleancode.course.commands;

public class CommandLine {

    public static final int COMMAND_POSITION = 0;
    public static final String SEPARATOR = " ";
    public static final int REST_OF_PARAMETERS_POSITION = 1;
    public static final int TIMES_TO_APPLY_SEPARATOR = 2;
    public static final String NOTHING = "";

    private String commandLine;

    public CommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public String extractCommand() {
        return processCommandLine()[COMMAND_POSITION];
    }

    public String getRestOfParameters() {
        var temporalSplit = processCommandLine();
        if(temporalSplit.length > 1) {
            return processCommandLine()[REST_OF_PARAMETERS_POSITION];
        }
        return NOTHING;
    }

    private String[] processCommandLine() {
        return commandLine.split(SEPARATOR, TIMES_TO_APPLY_SEPARATOR);
    }
}
