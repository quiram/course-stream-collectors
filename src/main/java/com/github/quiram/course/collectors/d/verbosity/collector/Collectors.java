package com.github.quiram.course.collectors.d.verbosity.collector;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static <T> Collector<T, ?, T> toSingleton(String errorIfEmpty, Function<List<T>, String> errorSupplierIfTooMany) {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() == 1) {
                        return list.get(0);
                    }

                    final String errorMessage;
                    if (list.size() == 0) {
                        errorMessage = errorIfEmpty;
                    } else {
                        errorMessage = errorSupplierIfTooMany.apply(list);
                    }

                    throw new RuntimeException(errorMessage);
                }
        );
    }
}
