package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.*;

abstract class CommandTestBase {

    protected abstract Command command();

    protected abstract String supportedSample();

    @Test
    void notSupportedInAnyOtherCase() {
        assertFalse(command().supports(randomString()));
    }

    @Test
    void supportedIfExpectedString() {
        assertTrue(command().supports(supportedSample()));
    }

    @Test
    void supportedIfExpectedStringSurroundedByEmptySpace() {
        final Command command = command();
        final String input = "   " + supportedSample() + "    ";
        assertTrue(command.supports(input));
        assertNotNull(command.apply(input));
    }

    @Test
    void failsIfApplyingUnsupportedCommand() {
        assertThrows(UnsupportedCommandException.class, () -> command().apply(randomString()));
    }
}
