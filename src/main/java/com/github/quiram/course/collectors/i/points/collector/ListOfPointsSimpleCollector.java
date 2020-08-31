package com.github.quiram.course.collectors.i.points.collector;

import com.github.quiram.course.collectors.i.points.Point;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ListOfPointsSimpleCollector {
    public static Collector<Integer, ?, List<Point>> toListOfPoints() {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() % 2 != 0) {
                        throw new RuntimeException("Cannot create a list of Points from an odd number of integers.");
                    }

                    return IntStream.range(0, list.size() / 2)
                            .mapToObj(i -> {
                                final Point point = new Point();
                                point.x = list.get(2 * i);
                                point.y = list.get(2 * i + 1);
                                return point;
                            })
                            .collect(toList());
                }
        );
    }

}
