package com.github.quiram.course.collectors.e.errors.vehicles;

public abstract class Vehicle {
    public abstract int numberOfWheels();

    public final String type() {
        return this.getClass().getSimpleName().toLowerCase();
    }
}
