# Task 6: CompletableFuture Aggregation

## Description

Asynchronous data aggregation from three independent sources: price, description, and rating.

## Classes

### ProductInfo

| Field         | Type     | Description          |
|---------------|----------|----------------------|
| name          | String   | Product name         |
| price         | double   | Product price        |
| description   | String   | Product description  |
| rating        | double   | Product rating       |

### DataAggregator

| Method                                 | Description                                          |
|----------------------------------------|------------------------------------------------------|
| aggregateProductInfo(String)           | Returns aggregated ProductInfo from three sources    |

## Usage Example

```java
DataAggregator aggregator = new DataAggregator();
ProductInfo info = aggregator.aggregateProductInfo("Ноутбук");
```

## Build and Run

```bash
javac src/task4_concurrency/completable_future/*.java
java -cp src task4_concurrency.completable_future.CompletableFutureExample
```

## Expected Output

```text
ProductInfo{name='Ноутбук', price=899.99, description='High-performance Ноутбук with advanced features', rating=4.7}
```