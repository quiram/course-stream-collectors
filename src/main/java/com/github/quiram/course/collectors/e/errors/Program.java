package com.github.quiram.course.collectors.e.errors;

import com.github.quiram.course.collectors.e.errors.vehicles.*;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Program {
    private static final List<Vehicle> vehicles = asList(
            new Bicycle(),
            new Bicycle(),

            new Motorbike(),
            new Motorbike(),

            new Car(),

            new Truck(),
            new Truck(),
            new Truck()
    );

    public static void main(String[] args) {
        taxableVehicles().forEach(v ->
                System.out.printf("Vehicle: %s, Expected tax: £%d%n", v, v.engineCapacity() / 2)
        );
    }

    private static List<MotorVehicle> taxableVehicles() {
        return vehicles.stream()
                .filter(v -> v.numberOfWheels() > 2)
                .map(MotorVehicle.class::cast)
                .collect(toList());
    }
}
