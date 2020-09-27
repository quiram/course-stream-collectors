package com.github.quiram.course.collectors.h.errors.collector;

import java.util.List;
import java.util.stream.Collector;

import static java.lang.String.format;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static <P, T extends P> Collector<P, ?, List<T>> toListOf(Class<T> klass) {
        return collectingAndThen(
                toList(),
                list -> {
                    final List<P> offendingItems = list.stream()
                            .filter(p -> !klass.isAssignableFrom(p.getClass()))
                            .collect(toList());

                    if (offendingItems.isEmpty()) {
                        return list.stream()
                                .map(klass::cast)
                                .collect(toList());
                    }

                    throw new RuntimeException(format("The following items cannot be cast to %s: %s", klass.getSimpleName(), offendingItems));
                });
    }
}
