// Data exporter interface with default methods
interface DataExporter {
    void exportToCSV(String data);
    void exportToPDF(String data);
    
    // Default JSON export method - added later without breaking existing code
    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON format:");
        System.out.println("{");
        System.out.println("  \"data\": \"" + data + "\",");
        System.out.println("  \"format\": \"JSON\",");
        System.out.println("  \"timestamp\": \"" + java.time.LocalDateTime.now() + "\"");
        System.out.println("}");
        System.out.println("JSON export completed\n");
    }
    
    // Default method for export summary
    default void exportSummary(String data, String format) {
        System.out.println("Export Summary:");
        System.out.println("Format: " + format);
        System.out.println("Data length: " + data.length() + " characters");
        System.out.println("Export time: " + java.time.LocalDateTime.now());
        System.out.println();
    }
}

// Sales report exporter (old implementation)
class SalesReportExporter implements DataExporter {
    @Override
    public void exportToCSV(String data) {
        System.out.println("Sales Report - CSV Export:");
        System.out.println("Date,Product,Sales,Revenue");
        System.out.println(data);
        exportSummary(data, "CSV");
    }
    
    @Override
    public void exportToPDF(String data) {
        System.out.println("Sales Report - PDF Export:");
        System.out.println("Generating PDF with sales data...");
        System.out.println("Data: " + data);
        exportSummary(data, "PDF");
    }
}

// Financial report exporter (new implementation with custom JSON)
class FinancialReportExporter implements DataExporter {
    @Override
    public void exportToCSV(String data) {
        System.out.println("Financial Report - CSV Export:");
        System.out.println("Account,Debit,Credit,Balance");
        System.out.println(data);
        exportSummary(data, "CSV");
    }
    
    @Override
    public void exportToPDF(String data) {
        System.out.println("Financial Report - PDF Export:");
        System.out.println("Generating financial PDF report...");
        System.out.println("Data: " + data);
        exportSummary(data, "PDF");
    }
    
    @Override
    public void exportToJSON(String data) {
        System.out.println("Financial Report - Custom JSON Export:");
        System.out.println("{");
        System.out.println("  \"reportType\": \"Financial\",");
        System.out.println("  \"data\": \"" + data + "\",");
        System.out.println("  \"currency\": \"INR\",");
        System.out.println("  \"generatedBy\": \"FinancialSystem\",");
        System.out.println("  \"timestamp\": \"" + java.time.LocalDateTime.now() + "\"");
        System.out.println("}");
        exportSummary(data, "Custom JSON");
    }
}

public class DataExportFeature {
    
    public static void demonstrateExport(DataExporter exporter, String data, String exporterType) {
        System.out.println("=== " + exporterType + " ===");
        
        exporter.exportToCSV(data);
        exporter.exportToPDF(data);
        exporter.exportToJSON(data); // Uses default or custom implementation
        
        System.out.println("----------------------------------------\n");
    }
    
    public static void main(String[] args) {
        String salesData = "2024-01-01,Laptop,10,50000";
        String financialData = "Cash Account,0,25000,25000";
        
        DataExporter salesExporter = new SalesReportExporter();
        DataExporter financialExporter = new FinancialReportExporter();
        
        demonstrateExport(salesExporter, salesData, "Sales Report Exporter");
        demonstrateExport(financialExporter, financialData, "Financial Report Exporter");
    }
}