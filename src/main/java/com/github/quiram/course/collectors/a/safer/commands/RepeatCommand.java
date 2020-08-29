package com.github.quiram.course.collectors.a.safer.commands;

public class RepeatCommand extends Command {
    @Override
    public boolean supports(String command) {
        return command.startsWith("repeat ");
    }

    @Override
    public String safelyApply(String command) {
        return command.substring(7);
    }

    @Override
    public String toString() {
        return "repeat";
    }
}
