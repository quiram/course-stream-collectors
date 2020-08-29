package com.github.quiram.course.collectors.g.errors;

import com.github.quiram.course.collectors.e.errors.vehicles.*;
import com.github.quiram.course.collectors.f.errors.vehicles.Quadricycle;
import com.github.quiram.course.collectors.f.errors.vehicles.Tricycle;

import java.util.List;

import static com.github.quiram.course.collectors.g.errors.collector.Collectors.toMotorVehicleList;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public class Program {
    private static final List<Vehicle> vehicles = asList(
            new Bicycle(),
            new Bicycle(),

            new Tricycle(),

            new Quadricycle(),
            new Quadricycle(),
            new Quadricycle(),

            new Motorbike(),
            new Motorbike(),

            new Car(),

            new Truck(),
            new Truck(),
            new Truck()
    );

    public static void main(String[] args) {
        taxableVehicles().forEach(v ->
                System.out.println(format("Vehicle: %s, Expected tax: £%d", v, v.engineCapacity() / 2))
        );
    }

    private static List<MotorVehicle> taxableVehicles() {
        return vehicles.stream()
                .filter(v -> v.numberOfWheels() > 2)
                .collect(toMotorVehicleList());
    }
}
