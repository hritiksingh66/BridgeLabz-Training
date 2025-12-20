import java.util.Scanner;

// Program to store positive numbers and calculate their sum
public class NumberStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store up to 10 numbers
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        // Input numbers until 0/negative or maximum 10 numbers
        System.out.println("Enter numbers (maximum 10). Enter 0 or negative number to stop:");
        
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double number = sc.nextDouble();
            
            // Stop if number is 0 or negative
            if (number <= 0) {
                break;
            }
            
            // Stop if maximum capacity reached
            if (index == 10) {
                break;
            }
            
            // Store the positive number
            numbers[index] = number;
            index++;
        }
        
        // Display all entered numbers and calculate sum
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        
        // Display total sum
        System.out.println("\nSum of all numbers: " + total);
        
        sc.close();
    }
}
