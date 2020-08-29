package com.github.quiram.course.collectors.a.safer.commands;

public abstract class Command {
    abstract boolean supports(String command);

    final String apply(String command) {
        if (!supports(command)) {
            throw new UnsupportedCommandException(command);
        }

        return safelyApply(command);
    }

    abstract protected String safelyApply(String command);
}
