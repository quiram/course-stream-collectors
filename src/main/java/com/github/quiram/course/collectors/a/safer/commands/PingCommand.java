package com.github.quiram.course.collectors.a.safer.commands;

public class PingCommand extends Command {
    @Override
    protected boolean safelySupports(String command) {
        return "ping".equals(command);
    }

    @Override
    protected String safelyApply(String command) {
        return "pong!";
    }
}
