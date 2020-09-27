package com.github.quiram.course.collectors.i.points;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();

            try {
                final List<Integer> numbers = stream(input.split("\\s")) // Stream<String>
                        .filter(not(String::isEmpty)) // Stream<String> (no empty strings)
                        .map(Integer::parseInt) // Stream<Integer>
                        .collect(toList()); // List<Integer>

                if (numbers.size() % 2 != 0) {
                    throw new RuntimeException("Cannot create a list of Points from an odd number of integers.");
                }

                final List<Point> points = new ArrayList<>();
                for (int i = 0; i < numbers.size(); i += 2) {
                    final Point point = new Point();
                    point.x = numbers.get(i);
                    point.y = numbers.get(i + 1);
                    points.add(point);
                }

                points.forEach(
                        point -> System.out.printf("(%d, %d)%n", point.x, point.y)
                );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
