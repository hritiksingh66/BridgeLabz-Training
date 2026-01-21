import java.io.*;
import java.util.*;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;
    
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
    
    @Override
    public String toString() {
        return String.format("Student[ID=%d, Name=%s, Age=%d, Marks=%.2f]", 
                           id, name, age, marks);
    }
}

public class CSVToObjects {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        List<Student> students = convertToObjects(filePath);
        
        System.out.println("=== Student Objects ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        sc.close();
    }
    
    // Convert CSV rows to Student objects
    public static List<Student> convertToObjects(String filePath) {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                
                // Parse CSV data to Student object
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());
                
                students.add(new Student(id, name, age, marks));
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
        
        return students;
    }
}