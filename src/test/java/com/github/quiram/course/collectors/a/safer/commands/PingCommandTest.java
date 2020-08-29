package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PingCommandTest extends CommandTestBase {
    @Override
    protected Command command() {
        return new PingCommand();
    }

    @Override
    protected String supportedSample() {
        return "ping";
    }

    @Test
    void getResponse() {
        assertEquals("pong!", command().apply("ping"));
    }
}