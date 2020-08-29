package com.github.quiram.course.collectors.a.safer.commands;

public abstract class Command {
    public final boolean supports(String command) {
        return safelySupports(command.trim());
    }

    abstract protected boolean safelySupports(String command);

    public final String apply(String command) {
        if (!supports(command)) {
            throw new UnsupportedCommandException(command);
        }

        return safelyApply(command.trim());
    }

    abstract protected String safelyApply(String command);
}
