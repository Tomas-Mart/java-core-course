# Task 4: Blocking Queue

## Description

Fixed-size blocking queue implementation with producer-consumer coordination using wait/notify.

## Methods

| Method     | Description                                           |
|------------|-------------------------------------------------------|
| enqueue(T) | Adds element, blocks if queue is full                 |
| dequeue()  | Removes and returns element, blocks if queue is empty |
| size()     | Returns current queue size                            |

## Usage Example

```java
BlockingQueue<Integer> queue = new BlockingQueue<>(3);

queue.

enqueue(1);

int value = queue.dequeue();
```

## Build and Run

```bash
javac src/task4_concurrency/blocking_queue/*.java
java -cp src task4_concurrency.blocking_queue.BlockingQueueExample
```

## Expected Output

```text
Produced: 1, size: 1
Produced: 2, size: 2
Consumed: 1, size: 1
Produced: 3, size: 2
Consumed: 2, size: 1
Produced: 4, size: 2
Consumed: 3, size: 1
Produced: 5, size: 2
Consumed: 4, size: 1
Consumed: 5, size: 0
Final size: 0
```