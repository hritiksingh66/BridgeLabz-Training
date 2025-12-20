import java.util.Scanner;

// Program to check voting eligibility for students based on age
public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store ages of 10 students
        int[] ages = new int[10];
        
        // Input ages of 10 students
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        
        // Check voting eligibility for each student
        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age");
            } else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }
        
        sc.close();
    }
}
