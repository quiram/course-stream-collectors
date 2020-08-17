package com.github.quiram.course.collectors.a.safer.commands;

public interface Command {
    boolean supports(String command);

    String apply(String command);
}
