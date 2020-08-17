package com.github.quiram.course.collectors.a.safer.commands;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.join;
import static java.util.Collections.reverse;

public class ReverseCommand implements Command {
    @Override
    public boolean supports(String command) {
        return command.endsWith(" in reverse");
    }

    @Override
    public String apply(String command) {
        if (!supports(command)) {
            throw new UnsupportedCommandException(command);
        }

        final List<String> words = Arrays.asList(command.substring(0, command.length() - 11).split("\\s"));
        reverse(words);
        return join(" ", words);
    }

    @Override
    public String toString() {
        return "reverse";
    }
}
