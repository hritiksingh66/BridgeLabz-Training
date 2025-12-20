import java.util.Scanner;

// Program to calculate employee bonus based on years of service
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays to store employee data
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalary = new double[10];
        double[] bonusAmount = new double[10];
        
        // Variables to track totals
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        
        // Input salary and years of service for 10 employees
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salary[i] = sc.nextDouble();
            if (salary[i] < 0) {
                System.out.println("Invalid salary. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = sc.nextDouble();
            if (yearsOfService[i] < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                continue;
            }
        }
        
        // Calculate bonus and new salary for each employee
        for (int i = 0; i < 10; i++) {
            // 5% bonus for >5 years, 2% for <=5 years
            if (yearsOfService[i] > 5) {
                bonusAmount[i] = salary[i] * 0.05;
            } else {
                bonusAmount[i] = salary[i] * 0.02;
            }
            
            // Calculate new salary and update totals
            newSalary[i] = salary[i] + bonusAmount[i];
            totalBonus += bonusAmount[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        
        // Display employee bonus details
        System.out.println("\nEmployee Bonus Details:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + " - Old Salary: " + salary[i] + 
                             ", Bonus: " + bonusAmount[i] + ", New Salary: " + newSalary[i]);
        }
        
        // Display summary totals
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        sc.close();
    }
}
