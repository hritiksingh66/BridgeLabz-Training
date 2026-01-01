import java.util.*;

// Course class
class Course {
    String name;
    String code;
    Professor professor; // Association - course has one professor
    List<Student> students; // Association - course has many students
    
    Course(String name, String code) {
        this.name = name;
        this.code = code;
        this.students = new ArrayList<>();
    }
    
    // Assign professor to course
    void assignProfessor(Professor prof) {
        this.professor = prof;
        prof.addCourse(this);
        System.out.println("Prof. " + prof.name + " assigned to " + name);
    }
    
    // Add student to course
    void addStudent(Student student) {
        students.add(student);
    }
    
    // Show course info
    void showInfo() {
        System.out.println("Course: " + name + " (" + code + ")");
        if (professor != null) {
            System.out.println("  Professor: " + professor.name);
        }
        System.out.println("  Students enrolled: " + students.size());
    }
}

// Student class
class Student {
    String name;
    int rollNo;
    List<Course> courses; // Association - student has multiple courses
    
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.courses = new ArrayList<>();
    }
    
    // Communication method - student enrolls in course
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.name);
    }
    
    // Show student's courses
    void showCourses() {
        System.out.println(name + " (Roll: " + rollNo + ") is enrolled in:");
        for (Course c : courses) {
            System.out.println("  - " + c.name);
        }
    }
}

// Professor class
class Professor {
    String name;
    String department;
    List<Course> courses; // Association - professor teaches multiple courses
    
    Professor(String name, String department) {
        this.name = name;
        this.department = department;
        this.courses = new ArrayList<>();
    }
    
    // Add course to professor's list
    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }
    
    // Show professor's courses
    void showCourses() {
        System.out.println("Prof. " + name + " (" + department + ") teaches:");
        for (Course c : courses) {
            System.out.println("  - " + c.name + " (" + c.students.size() + " students)");
        }
    }
}

// University Management System
class University {
    String name;
    List<Student> students; // Aggregation
    List<Professor> professors; // Aggregation
    List<Course> courses; // Aggregation
    
    University() {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    // Add student
    void addStudent(Student student) {
        students.add(student);
    }
    
    // Add professor
    void addProfessor(Professor professor) {
        professors.add(professor);
    }
    
    // Add course
    void addCourse(Course course) {
        courses.add(course);
    }
    
    // Show university stats
    void showStats() {
        System.out.println("University: " + name);
        System.out.println("Students: " + students.size());
        System.out.println("Professors: " + professors.size());
        System.out.println("Courses: " + courses.size());
    }
}

// Main class to demonstrate the system
public class UniversityManagement {
    public static void main(String[] args) {
        // Create university management system
        University uni = new University();
        
        // Create students
        Student alice = new Student("Alice Johnson", 101);
        Student bob = new Student("Bob Smith", 102);
        Student charlie = new Student("Charlie Brown", 103);
        
        // Create professors
        Professor profJava = new Professor("Dr. Wilson", "Computer Science");
        Professor profMath = new Professor("Dr. Taylor", "Mathematics");
        
        // Create courses
        Course java = new Course("Java Programming", "CS101");
        Course dataStruct = new Course("Data Structures", "CS102");
        Course calculus = new Course("Calculus", "MATH101");
        
        // Add to university
        uni.addStudent(alice);
        uni.addStudent(bob);
        uni.addStudent(charlie);
        uni.addProfessor(profJava);
        uni.addProfessor(profMath);
        uni.addCourse(java);
        uni.addCourse(dataStruct);
        uni.addCourse(calculus);
        
        // Assign professors to courses (Communication)
        java.assignProfessor(profJava);
        dataStruct.assignProfessor(profJava);
        calculus.assignProfessor(profMath);
        
        System.out.println();
        
        // Students enroll in courses (Communication)
        alice.enrollCourse(java);
        alice.enrollCourse(calculus);
        
        bob.enrollCourse(java);
        bob.enrollCourse(dataStruct);
        
        charlie.enrollCourse(dataStruct);
        charlie.enrollCourse(calculus);
        
        System.out.println();
        
        // Show university stats
        uni.showStats();
        System.out.println();
        
        // Show student enrollments
        alice.showCourses();
        bob.showCourses();
        charlie.showCourses();
        System.out.println();
        
        // Show professor assignments
        profJava.showCourses();
        profMath.showCourses();
        System.out.println();
        
        // Show course details
        java.showInfo();
        dataStruct.showInfo();
        calculus.showInfo();
    }
}