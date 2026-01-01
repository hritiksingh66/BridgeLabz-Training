import java.util.*;

// Employee Wage Computation Program - Master Branch
public class EmployeeWageComputation {
    
    // Class variables for wage calculation
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;
    
    // Employee attendance constants
    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;
    
    // Instance variables
    private String employeeName;
    private int totalWage;
    private int totalWorkingDays;
    private int totalWorkingHours;
    
    // Constructor
    public EmployeeWageComputation(String name) {
        this.employeeName = name;
        this.totalWage = 0;
        this.totalWorkingDays = 0;
        this.totalWorkingHours = 0;
    }
    
    // UC1: Check if employee is present or absent using random
    public int checkAttendance() {
        return (int) (Math.random() * 3); // Returns 0, 1, or 2
    }
    
    // UC2: Calculate daily employee wage for full time
    public int calculateDailyWage(int attendance) {
        switch (attendance) {
            case FULL_TIME:
                return WAGE_PER_HOUR * FULL_TIME_HOURS;
            case PART_TIME:
                return WAGE_PER_HOUR * PART_TIME_HOURS;
            default:
                return 0;
        }
    }
    
    // UC3: Get working hours based on attendance (using switch case)
    public int getWorkingHours(int attendance) {
        switch (attendance) {
            case FULL_TIME:
                return FULL_TIME_HOURS;
            case PART_TIME:
                return PART_TIME_HOURS;
            default:
                return 0;
        }
    }
    
    // UC5: Calculate wages for a month
    public void calculateMonthlyWage() {
        System.out.println("\n=== Monthly Wage Calculation for " + employeeName + " ===");
        
        int day = 1;
        totalWage = 0;
        totalWorkingDays = 0;
        totalWorkingHours = 0;
        
        // Continue until max hours or max days reached
        while (totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            int attendance = checkAttendance();
            int dailyHours = getWorkingHours(attendance);
            int dailyWage = calculateDailyWage(attendance);
            
            String attendanceStatus = getAttendanceStatus(attendance);
            
            if (attendance != ABSENT) {
                totalWorkingDays++;
                totalWorkingHours += dailyHours;
                totalWage += dailyWage;
                
                System.out.println("Day " + day + ": " + attendanceStatus + 
                                 " - Hours: " + dailyHours + 
                                 " - Daily Wage: Rs." + dailyWage);
            } else {
                System.out.println("Day " + day + ": " + attendanceStatus);
            }
            
            day++;
            
            // Break if we've checked all possible days in a month
            if (day > 31) break;
        }
        
        displayMonthlySummary();
    }
    
    // Helper method to get attendance status string
    private String getAttendanceStatus(int attendance) {
        switch (attendance) {
            case FULL_TIME:
                return "Full Time";
            case PART_TIME:
                return "Part Time";
            default:
                return "Absent";
        }
    }
    
    // Method to display monthly summary
    private void displayMonthlySummary() {
        System.out.println("\n--- Monthly Summary ---");
        System.out.println("Employee: " + employeeName);
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: Rs." + totalWage);
        System.out.println("Average Daily Wage: Rs." + 
                         (totalWorkingDays > 0 ? totalWage / totalWorkingDays : 0));
    }
    
    // Method to demonstrate individual use cases
    public void demonstrateUseCases() {
        System.out.println("\n=== Use Case Demonstrations ===");
        
        // UC1: Attendance check
        System.out.println("\nUC1: Checking Employee Attendance");
        for (int i = 1; i <= 5; i++) {
            int attendance = checkAttendance();
            System.out.println("Day " + i + ": " + getAttendanceStatus(attendance));
        }
        
        // UC2: Daily wage calculation
        System.out.println("\nUC2: Daily Wage Calculation");
        System.out.println("Full Time Wage: Rs." + calculateDailyWage(FULL_TIME));
        System.out.println("Part Time Wage: Rs." + calculateDailyWage(PART_TIME));
        System.out.println("Absent Wage: Rs." + calculateDailyWage(ABSENT));
        
        // UC3: Working hours using switch case
        System.out.println("\nUC3: Working Hours (Switch Case)");
        System.out.println("Full Time Hours: " + getWorkingHours(FULL_TIME));
        System.out.println("Part Time Hours: " + getWorkingHours(PART_TIME));
        System.out.println("Absent Hours: " + getWorkingHours(ABSENT));
    }
    
    // Main method
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("========================================");
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("Master Branch");
        System.out.println("========================================");
        
        Scanner scanner = new Scanner(System.in);
        
        // Get employee name
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();
        
        // Create employee wage computation object
        EmployeeWageComputation empWage = new EmployeeWageComputation(employeeName);
        
        // Menu for different operations
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Demonstrate Use Cases (UC1-UC3)");
            System.out.println("2. Calculate Monthly Wage (UC4-UC5)");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    empWage.demonstrateUseCases();
                    break;
                case 2:
                    empWage.calculateMonthlyWage();
                    break;
                case 3:
                    System.out.println("Thank you for using Employee Wage Computation Program!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}