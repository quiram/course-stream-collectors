package com.github.quiram.course.collectors.c.verbosity.collector;

import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static <T> Collector<T, ?, T> toSingleton() {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() == 1) {
                        return list.get(0);
                    }

                    throw new RuntimeException("Exactly one element expected, but got " + list);
                }
        );
    }
}
