package com.geometry;

public final class GeometryUtils {

    private GeometryUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static double squareMetersToSquareCentimeters(double squareMeters) {
        return squareMeters * 10000;
    }

    public static double squareCentimetersToSquareMeters(double squareCentimeters) {
        return squareCentimeters / 10000;
    }

    public static boolean areShapesEqual(Shape shape1, Shape shape2) {
        if (shape1 == null || shape2 == null) {
            return false;
        }
        return Double.compare(shape1.getArea(), shape2.getArea()) == 0
               && Double.compare(shape1.getPerimeter(), shape2.getPerimeter()) == 0;
    }

    public static boolean isShapeLarger(Shape shape1, Shape shape2) {
        if (shape1 == null || shape2 == null) {
            return false;
        }
        return shape1.getArea() > shape2.getArea();
    }

    public static Shape scaleShape(Shape shape, double factor) {
        if (shape == null || factor <= 0) {
            throw new IllegalArgumentException("Shape cannot be null and factor must be positive");
        }

        return switch (shape) {
            case Circle(double radius) -> new Circle(radius * factor);
            case Rectangle(double width, double height) -> new Rectangle(width * factor, height * factor);
            case Square(double side) -> new Square(side * factor);
            case Triangle(double sideA, double sideB, double sideC) -> new Triangle(
                    sideA * factor,
                    sideB * factor,
                    sideC * factor
            );
            default -> throw new UnsupportedOperationException(
                    "Scaling not supported for shape type: " + shape.getClass().getName()
            );
        };
    }
}