package com.github.quiram.course.collectors.a.safer.commands;

import java.util.List;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Collections.reverse;

public class ReverseCommand extends Command {
    @Override
    protected boolean safelySupports(String command) {
        return command.endsWith(" in reverse");
    }

    @Override
    public String safelyApply(String command) {
        final List<String> words = asList(command.substring(0, command.length() - 11).split("\\s"));
        reverse(words);
        return join(" ", words);
    }

    @Override
    public String toString() {
        return "reverse";
    }
}
