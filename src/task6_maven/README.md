# Task 9: Maven Multi-module Project (GeometryLibrary)

## Описание

Многомодульный Maven проект для работы с геометрическими фигурами.

## Модули

| Модуль                   | Описание                                            | Версия         |
|--------------------------|-----------------------------------------------------|----------------|
| geometry-library         | 2D фигуры (Circle, Rectangle, Triangle, Square)     | 1.1.0          |
| geometry-utils           | Утилиты: конвертация, сравнение, масштабирование    | 1.1.0-SNAPSHOT |
| three-dimensional-shapes | 3D фигуры (Cube, Sphere, Pyramid, RectangularPrism) | 1.1.0-SNAPSHOT |
| geometry-app             | Приложение для демонстрации                         | 1.0.0          |

## Управление версиями

| Модуль                   | Начальная версия | Текущая версия |
|--------------------------|------------------|----------------|
| geometry-library         | 1.0.0            | 1.1.0          |
| geometry-utils           | 1.0.0-SNAPSHOT   | 1.1.0-SNAPSHOT |
| three-dimensional-shapes | 1.0.0-SNAPSHOT   | 1.1.0-SNAPSHOT |

## Сборка и запуск

```bash
# Сборка всех модулей
mvn clean compile

# Запуск приложения
java -cp geometry-app/target/classes:geometry-library/target/classes:geometry-utils/target/classes:three-dimensional-shapes/target/classes com.app.GeometryApp
```

## Ожидаемый вывод

```text
=== 2D Shapes ===
Square: Area=25.00, Perimeter=20.00
Circle: Area=78.54, Perimeter=31.42, Diameter=10.00
Triangle: Area=6.00, Perimeter=12.00
Rectangle: Area=24.00, Perimeter=20.00

=== 3D Shapes ===
Cube: Volume=125.00, Surface Area=150.00, Diagonal=0.00
Sphere: Volume=523.60, Surface Area=314.16, Diagonal=0.00
Pyramid: Volume=20.00, Surface Area=49.20, Diagonal=0.00
RectangularPrism: Volume=48.00, Surface Area=88.00, Diagonal=0.00

=== GeometryUtils Demo ===
Circle area: 78.54 m² = 785398.16 cm² = 78.54 m²
Circle and Rectangle are equal: false
Circle is larger than Rectangle: true
Scaled Circle (factor=2.0): Area=314.16, Perimeter=62.83
```

## Структура проекта

```text
task6_maven/
├── pom.xml                                    # Parent POM
├── geometry-app/
│   ├── pom.xml
│   └── src/main/java/com/app/
│       └── GeometryApp.java
├── geometry-library/
│   ├── pom.xml
│   └── src/main/java/com/geometry/
│       ├── Shape.java
│       ├── Circle.java
│       ├── Rectangle.java
│       ├── Square.java
│       └── Triangle.java
├── geometry-utils/
│   ├── pom.xml
│   └── src/main/java/com/geometry/
│       └── GeometryUtils.java
└── three-dimensional-shapes/
    ├── pom.xml
    └── src/main/java/com/geometry/
        ├── ThreeDimensionalShape.java
        ├── Cube.java
        ├── Sphere.java
        ├── Pyramid.java
        └── RectangularPrism.java
```