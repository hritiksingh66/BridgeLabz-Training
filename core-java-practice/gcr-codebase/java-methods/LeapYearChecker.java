import java.util.Scanner;

// Program to check if a year is a leap year using Gregorian calendar rules
public class LeapYearChecker {
    
    // Check if given year is a leap year
    public static boolean isLeapYear(int year) {
        // Gregorian calendar starts from 1582
        if (year < 1582) {
            return false;
        }
        
        // Leap year rules:
        // 1. Divisible by 4
        // 2. If divisible by 100, must also be divisible by 400
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // Divisible by 400
                } else {
                    return false; // Divisible by 100 but not 400
                }
            } else {
                return true; // Divisible by 4 but not 100
            }
        } else {
            return false; // Not divisible by 4
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get year from user
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        // Validate year
        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar)");
            return;
        }
        
        // Check and display result
        boolean isLeap = isLeapYear(year);
        
        if (isLeap) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        scanner.close();
    }
}
