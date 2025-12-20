import java.util.Scanner;

// Program to calculate BMI for multiple persons using arrays
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number of persons
        System.out.print("Enter number of persons: ");
        int numberOfPersons = sc.nextInt();
        
        // Create arrays to store data
        double[] weight = new double[numberOfPersons];
        double[] height = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];
        
        // Input weight and height for each person
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (in kg): ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " (in meters): ");
            height[i] = sc.nextDouble();
        }
        
        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            // Determine weight status based on BMI
            if (bmi[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] >= 25.0 && bmi[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results in tabular format
        System.out.println("\nBMI Results:");
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");
        System.out.println("------\t------\t------\t---\t------");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", 
                            (i + 1), height[i], weight[i], bmi[i], weightStatus[i]);
        }
        
        sc.close();
    }
}
