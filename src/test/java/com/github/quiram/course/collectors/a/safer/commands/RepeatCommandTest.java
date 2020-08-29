package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatCommandTest extends CommandTestBase {

    @Override
    protected RepeatCommand command() {
        return new RepeatCommand();
    }

    @Override
    protected String supportedSample() {
        return "repeat " + randomString();
    }

    @Test
    void repeatsEverythingAfterTheCommand() {
        final String order = randomString();
        final String result = command().apply(" repeat " + order);
        assertEquals(order, result);
    }

}