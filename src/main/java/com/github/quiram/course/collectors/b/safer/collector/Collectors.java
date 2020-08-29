package com.github.quiram.course.collectors.b.safer.collector;

import java.util.Optional;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static <T> Collector<T, ?, Optional<T>> toMaybeOne() {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() == 0) {
                        return Optional.empty();
                    }

                    if (list.size() == 1) {
                        return Optional.of(list.get(0));
                    }

                    throw new RuntimeException("At most one element expected, but got " + list);
                }
        );
    }
}
