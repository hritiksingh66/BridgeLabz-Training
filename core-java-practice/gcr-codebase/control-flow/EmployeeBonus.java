import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
      // Creating Scanner object for taking input from keyboard
        Scanner sc = new Scanner(System.in);
        
        // Taking input salary and year of serviice from user 
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = sc.nextInt();
        
        // initialize bonusAmount of employee with 0.0
        double bonusAmount = 0.0;
        
        // Checking condition
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
        }
        
        // Printing result
        System.out.println("Bonus amount: " + bonusAmount);
        
        sc.close();
    }
}
