package com.github.quiram.course.collectors.a.safer.commands;

import static java.lang.String.format;

public class UnsupportedCommandException extends RuntimeException {
    public UnsupportedCommandException(String command) {
        super(format("Unsupported command: '%s'", command));
    }
}
