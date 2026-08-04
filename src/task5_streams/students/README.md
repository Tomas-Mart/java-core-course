# Task 8: Stream API - Aggregate and Merge Results

## Description

Calculate average grade for each subject using Parallel Stream.

## Requirements

- Create collection of students with subjects and grades
- Use Parallel Stream for processing
- Create Map where key = subject, value = average grade
- Print result

## Implementation

```java
List<Student> students = Arrays.asList(
        new Student("Student1", Map.of("Math", 90, "Physics", 85)),
        new Student("Student2", Map.of("Math", 95, "Physics", 88)),
        new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
        new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
);

StudentProcessor processor = new StudentProcessor();
Map<String, Double> averageGrades = processor.calculateAverageGradesBySubject(students);
```

## Build and Run

```bash
javac src/task5_streams/students/*.java
java -cp src task5_streams.students.ParallelStreamCollectMapAdvancedExample
```

## Expected Output

```text
Average grades by subject:
Chemistry: 88.5
Math: 91.0
Physics: 83.67
```

## Classes

| Class                                     | Description                                                                     |
|-------------------------------------------|---------------------------------------------------------------------------------|
| `Student`                                 | Record with name and grades map                                                 |
| `StudentProcessor`                        | Processes students using parallel stream, calculates average grades per subject |
| `ParallelStreamCollectMapAdvancedExample` | Demonstrates student grade aggregation with sample data                         |