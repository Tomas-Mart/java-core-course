package com.geometry;

public record Square(double side) implements Shape {

    public Square {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square{side=" + side + "}";
    }
}