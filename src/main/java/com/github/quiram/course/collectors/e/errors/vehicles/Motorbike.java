package com.github.quiram.course.collectors.e.errors.vehicles;

public class Motorbike extends MotorVehicle {
    @Override
    public int engineCapacity() {
        return 500;
    }

    @Override
    public int numberOfWheels() {
        return 2;
    }
}
