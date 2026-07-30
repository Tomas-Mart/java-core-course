# Task 2: StringBuilder with Snapshot Pattern

## Description

Custom StringBuilder implementation with Snapshot (Memento) pattern support and undo operation.

## Implemented Methods

| Method                  | Description                         |
|-------------------------|-------------------------------------|
| MyStringBuilder(String) | Constructor with initial text       |
| append(String)          | Appends text to the end             |
| delete(int, int)        | Removes substring from start to end |
| undo()                  | Reverts the last operation          |
| toString()              | Returns current text content        |

## Snapshot Pattern Architecture

```text
MyStringBuilder (Originator)
├── String text
├── Stack<Snapshot> history
│
├── Snapshot (Memento)
│   └── String text
│
├── saveState()
└── undo()
```

## Usage Example

```java
MyStringBuilder builder = new MyStringBuilder("Hello")
        .append(" World")
        .delete(0, 5)
        .undo();

System.out.

println(builder); // Hello World
```

## Project Structure

```text
src/task2_stringbuilder/
├── Snapshot.java
├── MyStringBuilder.java
└── Main.java
```

## Snapshot Pattern Workflow

1. saveState() creates snapshot of current state and stores in history
2. undo() removes last snapshot and restores previous state
3. History stored in Stack<Snapshot> enables operations reversal

## Build and Run

```bash
javac src/task2_stringbuilder/*.java
java -cp src task2_stringbuilder.Main
```

## Expected Output

```text
Hello World
```

## Summary

- Snapshot (Memento) pattern implemented
- Undo functionality added
- Minimal code demonstrating pattern essence_