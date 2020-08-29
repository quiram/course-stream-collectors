package com.github.quiram.course.collectors.a.safer.commands;

public abstract class Command {
    abstract boolean supports(String command);

    abstract String apply(String command);
}
