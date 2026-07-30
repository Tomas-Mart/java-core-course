# Task 3: Collections

## Description

Utility class with collection transformation and counting operations using custom Function implementation.

## Methods

| Method                                    | Description                                            |
|-------------------------------------------|--------------------------------------------------------|
| `arrayMapping(String[], ToUpperFunction)` | Applies function to each element and returns new array |
| `countElements(String[])`                 | Returns map with element frequencies                   |

## Usage Example

```java
String[] words = {"hello", "world", "hello", "java", "world", "world"};

String[] mapped = CollectionUtils.arrayMapping(words, new ToUpperFunction());
// ["HELLO", "WORLD", "HELLO", "JAVA", "WORLD", "WORLD"]

Map<String, Integer> counts = CollectionUtils.countElements(words);
// {hello=2, world=3, java=1}
```

## Project Structure

```text
src/task3_collections/
├── ToUpperFunction.java   # Function implementation
├── CollectionUtils.java   # Utility class with mapping and counting
└── Main.java             # Demonstration
```

## Build and Run

```bash
javac src/task3_collections/*.java
java -cp src task3_collections.Main
```

## Expected Output

```text
HELLO WORLD HELLO JAVA WORLD WORLD 
{hello=2, world=3, java=1}
```