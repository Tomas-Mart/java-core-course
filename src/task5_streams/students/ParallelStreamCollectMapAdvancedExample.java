package task5_streams.students;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        StudentProcessor processor = new StudentProcessor();
        Map<String, Double> averageGrades = processor.calculateAverageGradesBySubject(students);

        System.out.println("Average grades by subject:");
        averageGrades.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}