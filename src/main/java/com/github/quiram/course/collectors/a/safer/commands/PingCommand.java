package com.github.quiram.course.collectors.a.safer.commands;

public class PingCommand extends Command {
    @Override
    protected boolean safelySupports(String input) {
        return "ping".equals(input);
    }

    @Override
    protected String safelyApply(String input) {
        return "pong!";
    }
}
