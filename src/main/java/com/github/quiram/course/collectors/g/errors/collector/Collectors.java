package com.github.quiram.course.collectors.g.errors.collector;

import com.github.quiram.course.collectors.e.errors.vehicles.MotorVehicle;
import com.github.quiram.course.collectors.e.errors.vehicles.Vehicle;

import java.util.List;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collectors {
    public static Collector<Vehicle, ?, List<MotorVehicle>> toMotorVehicleList() {
        return collectingAndThen(
                toList(),
                list -> {
                    final List<Vehicle> offendingItems = list.stream()
                            .filter(v -> !(v instanceof MotorVehicle))
                            .collect(toList());

                    if (offendingItems.isEmpty()) {
                        return list.stream()
                                .map(MotorVehicle.class::cast)
                                .collect(toList());
                    }

                    throw new RuntimeException("The following vehicles are not motor vehicles: " + offendingItems);
                });
    }
}
