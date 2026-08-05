package com.geometry;

public record Cube(double side) implements ThreeDimensionalShape {

    public Cube {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * side * side;
    }

    @Override
    public String toString() {
        return "Cube{side=" + side + "}";
    }
}