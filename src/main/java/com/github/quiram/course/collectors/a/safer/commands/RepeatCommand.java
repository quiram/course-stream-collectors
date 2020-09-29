package com.github.quiram.course.collectors.a.safer.commands;

public class RepeatCommand extends Command {
    @Override
    protected boolean safelySupports(String input) {
        return input.startsWith("repeat ");
    }

    @Override
    public String safelyApply(String input) {
        return input.substring(7);
    }

    @Override
    public String toString() {
        return "repeat";
    }
}
