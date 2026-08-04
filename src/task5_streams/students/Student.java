package task5_streams.students;

import java.util.Map;

public record Student(String name, Map<String, Integer> grades) {

    public Map<String, Integer> getGrades() {
        return grades;
    }
}