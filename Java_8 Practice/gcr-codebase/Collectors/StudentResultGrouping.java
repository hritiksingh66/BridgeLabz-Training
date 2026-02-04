import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String gradeLevel;
    private double score;
    
    public Student(String name, String gradeLevel, double score) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.score = score;
    }
    
    public String getName() { return name; }
    public String getGradeLevel() { return gradeLevel; }
    public double getScore() { return score; }
    
    @Override
    public String toString() {
        return String.format("%s (%.1f)", name, score);
    }
}

public class StudentResultGrouping {
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice Johnson", "Grade 10", 85.5),
            new Student("Bob Smith", "Grade 9", 78.2),
            new Student("Carol Davis", "Grade 10", 92.1),
            new Student("David Wilson", "Grade 11", 88.7),
            new Student("Emma Brown", "Grade 9", 91.3),
            new Student("Frank Miller", "Grade 11", 76.8),
            new Student("Grace Taylor", "Grade 10", 89.4),
            new Student("Henry Anderson", "Grade 9", 83.6),
            new Student("Ivy Moore", "Grade 11", 94.2),
            new Student("Jack Thompson", "Grade 10", 87.9)
        );
        
        System.out.println("=== Student Result Grouping ===\n");
        
        // Group students by grade level and collect names
        Map<String, List<String>> studentsByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGradeLevel,
                Collectors.mapping(Student::getName, Collectors.toList())
            ));
        
        System.out.println("Students grouped by grade level:");
        studentsByGrade.forEach((grade, names) -> {
            System.out.println(grade + ": " + names);
        });
        
        System.out.println("\n=== Additional Grouping Analysis ===");
        
        // Group students with their details
        Map<String, List<Student>> studentsWithDetails = students.stream()
            .collect(Collectors.groupingBy(Student::getGradeLevel));
        
        studentsWithDetails.forEach((grade, studentList) -> {
            System.out.println("\n" + grade + ":");
            studentList.forEach(student -> System.out.println("  " + student));
        });
        
        // Count students per grade
        Map<String, Long> countByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGradeLevel,
                Collectors.counting()
            ));
        
        System.out.println("\nStudent count by grade:");
        countByGrade.forEach((grade, count) -> 
            System.out.println(grade + ": " + count + " students"));
        
        // Average score by grade
        Map<String, Double> avgScoreByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGradeLevel,
                Collectors.averagingDouble(Student::getScore)
            ));
        
        System.out.println("\nAverage score by grade:");
        avgScoreByGrade.forEach((grade, avg) -> 
            System.out.printf("%s: %.1f%n", grade, avg));
    }
}