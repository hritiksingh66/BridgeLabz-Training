import java.util.Scanner;

// Program to display calendar for a given month and year using methods
public class CalendarDisplay {
    
    // Get month name from month number
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
    
    // Check if given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // February has 29 days in leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }
    
    // Calculate first day of month using Zeller's formula
    public static int getFirstDayOfMonth(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31*m0/12) % 7;
        return d0;
    }
    
    // Display calendar for given month and year
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        // Print header
        System.out.println(monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        // Print empty spaces for days before month starts
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        
        // Print all days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        
        if ((daysInMonth + firstDay) % 7 != 0) {
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get month and year from user
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        // Validate input
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a value between 1 and 12.");
            return;
        }
        
        if (year < 1) {
            System.out.println("Invalid year. Please enter a positive year.");
            return;
        }
        
        // Display calendar
        System.out.println();
        displayCalendar(month, year);
        
        scanner.close();
    }
}
