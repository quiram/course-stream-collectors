package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PingCommandTest extends CommandTestBase {
    @Override
    protected Command command() {
        return new PingCommand();
    }

    @Test
    void supportsWordPing() {
        assertTrue(command().supports("ping"));
    }

    @Test
    void getResponse() {
        assertEquals("pong!", command().apply("ping"));
    }
}