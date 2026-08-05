package com.geometry;

public interface ThreeDimensionalShape {

    double getVolume();

    double getSurfaceArea();

    default double getDiagonal() {
        return 0;
    }
}