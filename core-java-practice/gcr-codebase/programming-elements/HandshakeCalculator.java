import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int no_of_students = sc.nextInt();

        // Calculate maximum handshakes
        int max_handshakes = (no_of_students * (no_of_students - 1)) / 2;

        // Output
        System.out.println("The maximum number of possible handshakes is " + max_handshakes);

        sc.close();
    }
}
