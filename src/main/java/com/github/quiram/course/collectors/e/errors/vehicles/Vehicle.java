package com.github.quiram.course.collectors.e.errors.vehicles;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public abstract class Vehicle {
    private final String registration;
    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    protected Vehicle() {
        registration = generateRegistrationNumber();
    }

    private String generateRegistrationNumber() {
        final Random random = new Random();
        return IntStream.range(0, 7)
                .map(i -> random.nextInt(CHARACTERS.length()))
                .mapToObj(CHARACTERS::charAt)
                .map(c -> Character.toString(c))
                .collect(joining());
    }

    public abstract int numberOfWheels();

    private String type() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String toString() {
        return format("%s (%s)", registration, type());
    }
}
