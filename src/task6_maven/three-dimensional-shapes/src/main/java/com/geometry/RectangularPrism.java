package com.geometry;

public record RectangularPrism(double length, double width, double height) implements ThreeDimensionalShape {

    public RectangularPrism {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Length, width and height must be positive");
        }
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    @Override
    public String toString() {
        return "RectangularPrism{length=" + length + ", width=" + width + ", height=" + height + "}";
    }
}