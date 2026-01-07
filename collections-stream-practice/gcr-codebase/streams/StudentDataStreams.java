import java.io.*;
import java.util.Scanner;

// Student class to hold student data
class Student {
    private int rollNumber;
    private String name;
    private double gpa;
    
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
    
    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    
    @Override
    public String toString() {
        return String.format("Student[Roll=%d, Name=%s, GPA=%.2f]", rollNumber, name, gpa);
    }
}

public class StudentDataStreams {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file name to store student data: ");
        String fileName = scanner.nextLine();
        
        // Write student data
        writeStudentData(scanner, fileName);
        
        // Read and display student data
        readStudentData(fileName);
        
        scanner.close();
    }
    
    // Write student data using DataOutputStream
    public static void writeStudentData(Scanner scanner, String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            
            System.out.print("Enter number of students: ");
            int count = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            dos.writeInt(count); // Write count first
            
            for (int i = 0; i < count; i++) {
                System.out.println("Student " + (i + 1) + ":");
                
                System.out.print("Roll Number: ");
                int roll = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("Name: ");
                String name = scanner.nextLine();
                
                System.out.print("GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine();
                
                // Write primitive data
                dos.writeInt(roll);
                dos.writeUTF(name); // writeUTF for strings
                dos.writeDouble(gpa);
            }
            
            System.out.println("Student data written successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    
    // Read student data using DataInputStream
    public static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            
            int count = dis.readInt(); // Read count first
            System.out.println("\nReading " + count + " students:");
            
            for (int i = 0; i < count; i++) {
                // Read primitive data in same order
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                Student student = new Student(roll, name, gpa);
                System.out.println(student);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}