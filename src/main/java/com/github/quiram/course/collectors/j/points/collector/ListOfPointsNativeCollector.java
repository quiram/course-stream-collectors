package com.github.quiram.course.collectors.j.points.collector;

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

public class ListOfPointsNativeCollector implements Collector<Integer, ListOfPointsNativeCollector.Container, List<Point>> {

    public static Collector<Integer, ?, List<Point>> toListOfPoints() {
        return new ListOfPointsNativeCollector();
    }

    public static class Container {
        final List<Point> list;
        Optional<Integer> number;

        public Container() {
            list = new ArrayList<>();
            number = Optional.empty();
        }
    }

    @Override
    public Supplier<Container> supplier() {
        return Container::new;
    }

    @Override
    public BiConsumer<Container, Integer> accumulator() {
        return ((container, integer) -> {
            if (container.number.isEmpty()) {
                container.number = Optional.of(integer);
            } else {
                final Point point = new Point();
                point.x = container.number.get();
                point.y = integer;
                container.list.add(point);
                container.number = Optional.empty();
            }
        });
    }

    @Override
    public Function<Container, List<Point>> finisher() {
        return container -> {
            if (container.number.isEmpty()) {
                return container.list;
            }

            throw new RuntimeException("Cannot create a list of Points from an odd number of integers.");
        };
    }

    @Override
    public BinaryOperator<Container> combiner() {
        return ($1, $2) -> {
            throw new RuntimeException("This collector doesn't support parallel streams.");
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return emptySet();
    }
}
