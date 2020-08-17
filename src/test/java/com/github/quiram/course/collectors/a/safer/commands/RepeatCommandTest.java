package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.*;

class RepeatCommandTest {

    private final RepeatCommand command = new RepeatCommand();

    @Test
    void supportedIfStartsWithRepeat() {
        assertTrue(command.supports("repeat all this"));
    }

    @Test
    void notSupportedInAnyOtherCase() {
        assertFalse(command.supports(randomString()));
    }

    @Test
    void repeatsEverythingAfterTheCommand() {
        final String order = randomString();
        final String result = command.apply("repeat " + order);
        assertEquals(order, result);
    }

    @Test
    void failsIfApplyingUnsupportedCommand() {
        assertThrows(UnsupportedCommandException.class, () -> command.apply(randomString()));
    }
}