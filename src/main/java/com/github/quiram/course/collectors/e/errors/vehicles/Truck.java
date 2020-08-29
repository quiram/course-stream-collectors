package com.github.quiram.course.collectors.e.errors.vehicles;

public class Truck extends MotorVehicle {
    @Override
    public int numberOfWheels() {
        return 6;
    }

    @Override
    public int engineCapacity() {
        return 4000;
    }
}
