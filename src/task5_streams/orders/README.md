# Task 7: Stream API - Generate Numbers

## Description

Group orders by product, calculate total cost, and find top 3 most expensive products using Stream API.

## Requirements

- Create list of orders with different products and costs
- Group orders by product
- Calculate total cost for each product
- Sort products by total cost in descending order
- Select top 3 most expensive products
- Print result

## Implementation

```java
List<Order> orders = List.of(
        new Order("Laptop", 1200.0),
        new Order("Smartphone", 800.0),
        new Order("Laptop", 1500.0),
        new Order("Tablet", 500.0),
        new Order("Smartphone", 900.0)
);

OrderProcessor processor = new OrderProcessor();
var top3 = processor.getTop3ProductsByTotalCost(orders);
processor.printTop3Products(top3);
```

## Build and Run

```bash
javac src/task5_streams/orders/*.java
java -cp src task5_streams.orders.StreamCollectorsExample
```

## Expected Output

```text
Top 3 most expensive products:
Laptop - 2700.0
Smartphone - 1700.0
Tablet - 500.0
```

## Classes

| Class                     | Description                                                           |
|---------------------------|-----------------------------------------------------------------------|
| `Order`                   | Record with product name and cost                                     |
| `OrderProcessor`          | Processes orders, groups by product, calculates totals, returns top 3 |
| `StreamCollectorsExample` | Demonstrates order processing with sample data                        |