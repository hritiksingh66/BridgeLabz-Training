import java.util.*;

// Course class - represents a course
class Course {
    String name;
    List<Student> students; // Association - course has many students
    
    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    
    // Add student to course
    void addStudent(Student student) {
        students.add(student);
    }
    
    // Show all students in this course
    void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// Student class - represents a student
class Student {
    String name;
    List<Course> courses; // Association - student has many courses
    
    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    // Enroll student in a course
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // Two-way association
    }
    
    // Show all courses for this student
    void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

// School class - contains students (Aggregation)
class School {
    String name;
    List<Student> students; // Aggregation - school has students
    
    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    
    // Add student to school
    void addStudent(Student student) {
        students.add(student);
    }
    
    // Show all students in school
    void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// Main class to demonstrate the system
public class SchoolSystem {
    public static void main(String[] args) {
        // Create school
        School school = new School("ABC High School");
        
        // Create students
        Student john = new Student("John");
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        
        // Add students to school (Aggregation)
        school.addStudent(john);
        school.addStudent(alice);
        school.addStudent(bob);
        
        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course english = new Course("English");
        
        // Students enroll in courses (Association)
        john.enrollCourse(math);
        john.enrollCourse(science);
        
        alice.enrollCourse(math);
        alice.enrollCourse(english);
        
        bob.enrollCourse(science);
        bob.enrollCourse(english);
        
        // Display results
        school.showStudents();
        System.out.println();
        
        john.showCourses();
        alice.showCourses();
        bob.showCourses();
        System.out.println();
        
        math.showStudents();
        science.showStudents();
        english.showStudents();
    }
}