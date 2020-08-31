package com.github.quiram.course.collectors.i.points.collector;

import com.github.quiram.course.collectors.i.points.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Collections.emptySet;

public class ListOfPointsNativeCollector implements Collector<Integer, ListOfPointsNativeCollector.ResultContainer, List<Point>> {

    public static Collector<Integer, ?, List<Point>> toListOfPoints() {
        return new ListOfPointsNativeCollector();
    }

    @Override
    public Supplier<ResultContainer> supplier() {
        final ResultContainer resultContainer = new ResultContainer();
        resultContainer.list = new ArrayList<>();
        resultContainer.number = Optional.empty();
        return () -> resultContainer;
    }

    @Override
    public BiConsumer<ResultContainer, Integer> accumulator() {
        return ((resultContainer, integer) -> {
            if (resultContainer.number.isEmpty()) {
                resultContainer.number = Optional.of(integer);
            } else {
                final Point point = new Point();
                point.x = resultContainer.number.get();
                point.y = integer;
                resultContainer.list.add(point);
                resultContainer.number = Optional.empty();
            }
        });
    }

    @Override
    public Function<ResultContainer, List<Point>> finisher() {
        return resultContainer -> {
            if (resultContainer.number.isEmpty()) {
                return resultContainer.list;
            }

            throw new RuntimeException("Cannot create a list of Points from an odd number of integers.");
        };
    }

    public static class ResultContainer {
        List<Point> list;
        Optional<Integer> number;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return emptySet();
    }

    @Override
    public BinaryOperator<ResultContainer> combiner() {
        return null;
    }
}
