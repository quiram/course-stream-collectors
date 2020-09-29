package com.github.quiram.course.collectors.c.verbosity.collector;

import java.util.List;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static <T> Collector<T, ?, T> toSingleton(String noneError, String tooManyError) {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.isEmpty()) {
                        throw new RuntimeException(noneError);
                    }

                    if (list.size() == 1) {
                        return list.get(0);
                    }

                    throw new RuntimeException(tooManyError + list);
                }
        );
    }

    public static <T> Collector<T, ?, List<T>> toListOfSize(int min, int max) {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() >= min && list.size() < max) {
                        return list;
                    }

                    throw new RuntimeException(String.format("Expected between %d and %d elements, but got %s", min, max, list));
                });
    }
}
