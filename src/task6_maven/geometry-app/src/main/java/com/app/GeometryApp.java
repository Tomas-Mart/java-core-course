package com.app;

import com.geometry.Circle;
import com.geometry.Cube;
import com.geometry.GeometryUtils;
import com.geometry.Pyramid;
import com.geometry.Rectangle;
import com.geometry.RectangularPrism;
import com.geometry.Shape;
import com.geometry.Sphere;
import com.geometry.Square;
import com.geometry.ThreeDimensionalShape;
import com.geometry.Triangle;

public final class GeometryApp {

    private static final Circle CIRCLE_5 = new Circle(5.0);
    private static final Shape RECTANGLE_4x6 = new Rectangle(4.0, 6.0);

    private GeometryApp() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(String[] args) {
        print2DShapes();
        print3DShapes();
        printUtilsDemo();
    }

    private static void print2DShapes() {
        System.out.println("=== 2D Shapes ===");

        Shape[] shapes = {
                new Square(5.0),
                CIRCLE_5,
                new Triangle(3.0, 4.0, 5.0),
                RECTANGLE_4x6
        };

        for (Shape shape : shapes) {
            if (shape instanceof Circle circle) {
                System.out.printf("%s: Area=%.2f, Perimeter=%.2f, Diameter=%.2f%n",
                        circle.getClass().getSimpleName(),
                        circle.getArea(),
                        circle.getPerimeter(),
                        circle.getDiameter());
            } else {
                System.out.printf("%s: Area=%.2f, Perimeter=%.2f%n",
                        shape.getClass().getSimpleName(),
                        shape.getArea(),
                        shape.getPerimeter());
            }
        }
    }

    private static void print3DShapes() {
        System.out.println("\n=== 3D Shapes ===");

        ThreeDimensionalShape[] shapes = {
                new Cube(5.0),
                new Sphere(5.0),
                new Pyramid(3.0, 4.0, 5.0),
                new RectangularPrism(2.0, 4.0, 6.0)
        };

        for (ThreeDimensionalShape shape : shapes) {
            System.out.printf("%s: Volume=%.2f, Surface Area=%.2f, Diagonal=%.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.getVolume(),
                    shape.getSurfaceArea(),
                    shape.getDiagonal());
        }
    }

    private static void printUtilsDemo() {
        System.out.println("\n=== GeometryUtils Demo ===");

        double areaM2 = CIRCLE_5.getArea();
        double areaCm2 = GeometryUtils.squareMetersToSquareCentimeters(areaM2);
        double backToM2 = GeometryUtils.squareCentimetersToSquareMeters(areaCm2);

        Shape scaledCircle = GeometryUtils.scaleShape(CIRCLE_5, 2.0);

        System.out.printf("Circle area: %.2f m² = %.2f cm² = %.2f m²%n", areaM2, areaCm2, backToM2);
        System.out.printf("Circle and Rectangle are equal: %b%n", GeometryUtils.areShapesEqual(CIRCLE_5, RECTANGLE_4x6));
        System.out.printf("Circle is larger than Rectangle: %b%n", GeometryUtils.isShapeLarger(CIRCLE_5, RECTANGLE_4x6));
        System.out.printf("Scaled Circle (factor=2.0): Area=%.2f, Perimeter=%.2f%n", scaledCircle.getArea(), scaledCircle.getPerimeter());
    }
}