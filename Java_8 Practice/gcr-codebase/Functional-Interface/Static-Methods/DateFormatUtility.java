import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Date formatting interface with static methods
interface DateFormatter {
    
    // Standard date formats
    static String formatToISO(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    static String formatToUS(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
    
    static String formatToEuropean(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    static String formatToLong(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }
    
    static String formatToShort(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM dd, yy"));
    }
    
    // Invoice specific formats
    static String formatForInvoice(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }
    
    static String formatForFilename(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}

public class DateFormatUtility {
    
    public static void demonstrateFormats(LocalDate date) {
        System.out.println("Date: " + date);
        System.out.println("ISO Format: " + DateFormatter.formatToISO(date));
        System.out.println("US Format: " + DateFormatter.formatToUS(date));
        System.out.println("European Format: " + DateFormatter.formatToEuropean(date));
        System.out.println("Long Format: " + DateFormatter.formatToLong(date));
        System.out.println("Short Format: " + DateFormatter.formatToShort(date));
        System.out.println("Invoice Format: " + DateFormatter.formatForInvoice(date));
        System.out.println("Filename Format: " + DateFormatter.formatForFilename(date));
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Invoice Date Formatter ===\n");
        
        LocalDate today = LocalDate.now();
        LocalDate invoiceDate = LocalDate.of(2024, 3, 15);
        LocalDate dueDate = LocalDate.of(2024, 4, 15);
        
        System.out.println("Today's Date Formats:");
        demonstrateFormats(today);
        
        System.out.println("Invoice Date Formats:");
        demonstrateFormats(invoiceDate);
        
        System.out.println("Due Date Formats:");
        demonstrateFormats(dueDate);
        
        // Example invoice header
        System.out.println("=== Sample Invoice Header ===");
        System.out.println("Invoice Date: " + DateFormatter.formatForInvoice(invoiceDate));
        System.out.println("Due Date: " + DateFormatter.formatForInvoice(dueDate));
        System.out.println("Generated: " + DateFormatter.formatToLong(today));
    }
}