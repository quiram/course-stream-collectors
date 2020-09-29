package com.github.quiram.course.collectors.a.safer.commands;

public abstract class Command {
    public final boolean supports(String input) {
        return safelySupports(input.trim());
    }

    abstract protected boolean safelySupports(String input);

    public final String apply(String input) {
        if (!supports(input)) {
            throw new UnsupportedCommandException(input);
        }

        return safelyApply(input.trim());
    }

    abstract protected String safelyApply(String input);
}
