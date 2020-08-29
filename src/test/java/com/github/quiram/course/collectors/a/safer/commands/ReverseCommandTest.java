package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseCommandTest extends CommandTestBase {

    @Override
    protected Command command() {
        return new ReverseCommand();
    }

    @Override
    protected String supportedSample() {
        return randomString() + " in reverse";
    }

    @Test
    void returnWordsInReverseWhenApplying() {
        final String result = command().apply("something anything everything in reverse");
        assertEquals("everything anything something", result);
    }
}