package com.geometry;

public record Pyramid(double baseLength, double baseWidth, double height) implements ThreeDimensionalShape {

    public Pyramid {
        if (baseLength <= 0 || baseWidth <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base length, width and height must be positive");
        }
    }

    @Override
    public double getVolume() {
        return (baseLength * baseWidth * height) / 3.0;
    }

    @Override
    public double getSurfaceArea() {
        double baseArea = baseLength * baseWidth;
        double slantHeight = Math.sqrt(height * height + (baseLength / 2.0) * (baseLength / 2.0));
        double slantHeight2 = Math.sqrt(height * height + (baseWidth / 2.0) * (baseWidth / 2.0));
        double sideArea1 = (baseLength * slantHeight) / 2.0;
        double sideArea2 = (baseWidth * slantHeight2) / 2.0;
        return baseArea + 2 * sideArea1 + 2 * sideArea2;
    }

    @Override
    public String toString() {
        return "Pyramid{baseLength=" + baseLength + ", baseWidth=" + baseWidth + ", height=" + height + "}";
    }
}