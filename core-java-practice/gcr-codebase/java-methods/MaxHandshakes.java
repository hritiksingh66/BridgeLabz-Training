import java.util.Scanner;

// Program to calculate maximum possible handshakes among students
public class MaxHandshakes {
    
    // Calculate maximum handshakes using combination formula
    public static int calculateHandshakes(int numOfStudents) {
        return (numOfStudents * (numOfStudents - 1)) / 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number of students from user
        System.out.print("Enter number of students: ");
        int numOfStudents = scanner.nextInt();
        
        // Calculate and display result
        int handshakes = calculateHandshakes(numOfStudents);
        
        System.out.println("Maximum number of possible handshakes: " + handshakes);
        
        scanner.close();
    }
}