package com.github.quiram.course.collectors.j.points;

import com.github.quiram.course.collectors.i.points.Point;

import java.util.List;
import java.util.Scanner;

import static com.github.quiram.course.collectors.j.points.collector.ListOfPointsSimpleCollector.toListOfPoints;
import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;

public class Program {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();

            try {
                final List<Point> coordinates = stream(input.split("\\s")) // Stream<String>
                        .filter(not(String::isEmpty)) // Stream<String> (no empty strings)
                        .map(Integer::parseInt) // Stream<Integer>
                        .collect(toListOfPoints()); // List<Point>

                coordinates.forEach(
                        point -> System.out.printf("(%d, %d)%n", point.x, point.y)
                );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
