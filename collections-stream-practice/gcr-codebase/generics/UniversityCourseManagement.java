import java.util.*;

// Abstract base class for different course types
abstract class CourseType {
    protected String typeName;
    protected int maxStudents;
    
    public CourseType(String typeName, int maxStudents) {
        this.typeName = typeName;
        this.maxStudents = maxStudents;
    }
    
    // Abstract method for evaluation method
    public abstract String getEvaluationMethod();
    
    // Getters
    public String getTypeName() { return typeName; }
    public int getMaxStudents() { return maxStudents; }
    
    @Override
    public String toString() {
        return typeName + " (Max Students: " + maxStudents + ", Evaluation: " + getEvaluationMethod() + ")";
    }
}

// Exam-based course type
class ExamCourse extends CourseType {
    private int numberOfExams;
    
    public ExamCourse(int maxStudents, int numberOfExams) {
        super("Exam-Based Course", maxStudents);
        this.numberOfExams = numberOfExams;
    }
    
    @Override
    public String getEvaluationMethod() {
        return "Written Exams (" + numberOfExams + " exams)";
    }
    
    public int getNumberOfExams() { return numberOfExams; }
}

// Assignment-based course type
class AssignmentCourse extends CourseType {
    private int numberOfAssignments;
    
    public AssignmentCourse(int maxStudents, int numberOfAssignments) {
        super("Assignment-Based Course", maxStudents);
        this.numberOfAssignments = numberOfAssignments;
    }
    
    @Override
    public String getEvaluationMethod() {
        return "Assignments (" + numberOfAssignments + " assignments)";
    }
    
    public int getNumberOfAssignments() { return numberOfAssignments; }
}

// Research-based course type
class ResearchCourse extends CourseType {
    private String researchArea;
    
    public ResearchCourse(int maxStudents, String researchArea) {
        super("Research-Based Course", maxStudents);
        this.researchArea = researchArea;
    }
    
    @Override
    public String getEvaluationMethod() {
        return "Research Project in " + researchArea;
    }
    
    public String getResearchArea() { return researchArea; }
}

// Generic course class with bounded type parameter
class Course<T extends CourseType> {
    private String courseName;
    private String courseCode;
    private String department;
    private T courseType;
    private List<String> enrolledStudents;
    private String instructor;
    
    public Course(String courseName, String courseCode, String department, T courseType, String instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.department = department;
        this.courseType = courseType;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }
    
    // Enroll student in course
    public boolean enrollStudent(String studentName) {
        if (enrolledStudents.size() < courseType.getMaxStudents()) {
            enrolledStudents.add(studentName);
            System.out.println("Enrolled " + studentName + " in " + courseName);
            return true;
        } else {
            System.out.println("Cannot enroll " + studentName + " - Course is full");
            return false;
        }
    }
    
    // Get enrolled students count
    public int getEnrolledCount() {
        return enrolledStudents.size();
    }
    
    // Check if course is full
    public boolean isFull() {
        return enrolledStudents.size() >= courseType.getMaxStudents();
    }
    
    // Getters
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public String getDepartment() { return department; }
    public T getCourseType() { return courseType; }
    public String getInstructor() { return instructor; }
    public List<String> getEnrolledStudents() { return new ArrayList<>(enrolledStudents); }
    
    @Override
    public String toString() {
        return courseCode + ": " + courseName + " (" + department + ")\n" +
               "  Instructor: " + instructor + "\n" +
               "  Type: " + courseType + "\n" +
               "  Enrollment: " + enrolledStudents.size() + "/" + courseType.getMaxStudents();
    }
}

// Department class to manage courses
class Department {
    private String departmentName;
    private List<Course<? extends CourseType>> courses;
    
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }
    
    // Add course to department using wildcards
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
        System.out.println("Added course " + course.getCourseCode() + " to " + departmentName);
    }
    
    // Get all courses using wildcards
    public List<Course<? extends CourseType>> getAllCourses() {
        return new ArrayList<>(courses);
    }
    
    public String getDepartmentName() { return departmentName; }
}

// Multi-Level University Course Management System
public class UniversityCourseManagement {
    
    // Wildcard method to display all courses regardless of type
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("=== Course Listings ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }
        
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
            System.out.println();
        }
    }
    
    // Generic method to find courses by enrollment status
    public static <T extends CourseType> List<Course<T>> findCoursesByEnrollmentStatus(
            List<Course<T>> courses, boolean findFull) {
        List<Course<T>> result = new ArrayList<>();
        for (Course<T> course : courses) {
            if (course.isFull() == findFull) {
                result.add(course);
            }
        }
        return result;
    }
    
    // Method to get course statistics using wildcards
    public static void displayCourseStatistics(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("=== Course Statistics ===");
        
        int totalCourses = courses.size();
        int totalEnrolledStudents = 0;
        int fullCourses = 0;
        
        Map<String, Integer> courseTypeCount = new HashMap<>();
        
        for (Course<? extends CourseType> course : courses) {
            totalEnrolledStudents += course.getEnrolledCount();
            if (course.isFull()) {
                fullCourses++;
            }
            
            String courseType = course.getCourseType().getTypeName();
            courseTypeCount.put(courseType, courseTypeCount.getOrDefault(courseType, 0) + 1);
        }
        
        System.out.println("Total Courses: " + totalCourses);
        System.out.println("Total Enrolled Students: " + totalEnrolledStudents);
        System.out.println("Full Courses: " + fullCourses);
        System.out.println("Available Courses: " + (totalCourses - fullCourses));
        
        System.out.println("\nCourse Types Distribution:");
        for (Map.Entry<String, Integer> entry : courseTypeCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
    
    // Main method to demonstrate the system
    public static void main(String[] args) {
        System.out.println("=== Multi-Level University Course Management System ===\n");
        
        // Create departments
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");
        Department physicsDepartment = new Department("Physics");
        
        // Create different types of courses
        Course<ExamCourse> dataStructures = new Course<>(
            "Data Structures and Algorithms", "CS201", "Computer Science",
            new ExamCourse(30, 3), "Dr. Smith"
        );
        
        Course<AssignmentCourse> softwareEngineering = new Course<>(
            "Software Engineering", "CS301", "Computer Science",
            new AssignmentCourse(25, 5), "Prof. Johnson"
        );
        
        Course<ResearchCourse> aiResearch = new Course<>(
            "Artificial Intelligence Research", "CS401", "Computer Science",
            new ResearchCourse(10, "Machine Learning"), "Dr. Brown"
        );
        
        Course<ExamCourse> calculus = new Course<>(
            "Calculus I", "MATH101", "Mathematics",
            new ExamCourse(40, 2), "Prof. Davis"
        );
        
        Course<ResearchCourse> quantumPhysics = new Course<>(
            "Quantum Physics Research", "PHYS401", "Physics",
            new ResearchCourse(8, "Quantum Computing"), "Dr. Wilson"
        );
        
        // Add courses to departments
        csDepartment.addCourse(dataStructures);
        csDepartment.addCourse(softwareEngineering);
        csDepartment.addCourse(aiResearch);
        mathDepartment.addCourse(calculus);
        physicsDepartment.addCourse(quantumPhysics);
        
        // Enroll students in courses
        System.out.println("\n=== Student Enrollment ===");
        dataStructures.enrollStudent("Alice Johnson");
        dataStructures.enrollStudent("Bob Smith");
        dataStructures.enrollStudent("Carol Davis");
        
        softwareEngineering.enrollStudent("David Wilson");
        softwareEngineering.enrollStudent("Eva Brown");
        
        aiResearch.enrollStudent("Frank Miller");
        aiResearch.enrollStudent("Grace Lee");
        
        calculus.enrollStudent("Henry Taylor");
        calculus.enrollStudent("Ivy Chen");
        
        quantumPhysics.enrollStudent("Jack Anderson");
        
        // Collect all courses using wildcards
        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.addAll(csDepartment.getAllCourses());
        allCourses.addAll(mathDepartment.getAllCourses());
        allCourses.addAll(physicsDepartment.getAllCourses());
        
        // Display all courses
        System.out.println();
        displayAllCourses(allCourses);
        
        // Display course statistics
        displayCourseStatistics(allCourses);
        
        // Find available courses
        System.out.println("=== Available Courses (Not Full) ===");
        List<Course<? extends CourseType>> availableCourses = new ArrayList<>();
        for (Course<? extends CourseType> course : allCourses) {
            if (!course.isFull()) {
                availableCourses.add(course);
            }
        }
        displayAllCourses(availableCourses);
    }
}