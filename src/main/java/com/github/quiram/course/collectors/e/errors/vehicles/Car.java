package com.github.quiram.course.collectors.e.errors.vehicles;

public class Car extends MotorVehicle {
    @Override
    public int numberOfWheels() {
        return 4;
    }

    @Override
    public int engineCapacity() {
        return 1400;
    }
}
