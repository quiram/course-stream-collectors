package com.github.quiram.course.collectors.a.safer.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.quiram.utils.Random.randomString;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class CommandTestBase {

    protected abstract Command command();

    @Test
    void notSupportedInAnyOtherCase() {
        Assertions.assertFalse(command().supports(randomString()));
    }

    @Test
    void failsIfApplyingUnsupportedCommand() {
        assertThrows(UnsupportedCommandException.class, () -> command().apply(randomString()));
    }
}
