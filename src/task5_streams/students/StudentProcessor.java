package task5_streams.students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StudentProcessor {

    public Map<String, Double> calculateAverageGradesBySubject(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return Map.of();
        }

        return students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(
                                Collectors.averagingDouble(Map.Entry::getValue),
                                avg -> Math.round(avg * 100.0) / 100.0
                        )
                ));
    }
}