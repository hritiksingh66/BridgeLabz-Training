import java.util.Scanner;

// Program to find all factors of a number using dynamic array
public class FactorFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Initialize dynamic array for factors
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;
        
        // Find all factors of the number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Resize array if needed
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index] = i;
                index++;
            }
        }
        
        // Display all factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        
        sc.close();
    }
}
