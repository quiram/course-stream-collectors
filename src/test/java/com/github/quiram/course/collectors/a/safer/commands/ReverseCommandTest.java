package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReverseCommandTest extends CommandTestBase {

    @Override
    protected Command command() {
        return new ReverseCommand();
    }

    @Test
    void supportedIfItEndsWithInReverse() {
        assertTrue(command().supports(randomString() + " in reverse"));
    }

    @Test
    void returnWordsInReverseWhenApplying() {
        final String result = command().apply("something anything everything in reverse");
        assertEquals("everything anything something", result);
    }
}