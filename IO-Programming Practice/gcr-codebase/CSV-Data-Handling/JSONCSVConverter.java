import java.io.*;
import java.util.*;

public class JSONCSVConverter {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. JSON to CSV");
        System.out.println("2. CSV to JSON");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        if (choice == 1) {
            System.out.print("Enter JSON file path: ");
            String jsonFile = sc.nextLine();
            System.out.print("Enter output CSV file path: ");
            String csvFile = sc.nextLine();
            jsonToCSV(jsonFile, csvFile);
        } else if (choice == 2) {
            System.out.print("Enter CSV file path: ");
            String csvFile = sc.nextLine();
            System.out.print("Enter output JSON file path: ");
            String jsonFile = sc.nextLine();
            csvToJSON(csvFile, jsonFile);
        }
        
        sc.close();
    }
    
    // Convert simple JSON array to CSV (basic implementation)
    public static void jsonToCSV(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             PrintWriter pw = new PrintWriter(new FileWriter(csvFile))) {
            
            // Simple JSON parsing (assumes array of objects)
            String line;
            boolean firstRecord = true;
            
            pw.println("id,name,age,marks"); // CSV header
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.contains("\"id\"")) {
                    // Extract values (basic parsing)
                    String id = extractValue(line, "id");
                    String name = extractValue(line, "name");
                    String age = extractValue(line, "age");
                    String marks = extractValue(line, "marks");
                    
                    pw.printf("%s,%s,%s,%s%n", id, name, age, marks);
                }
            }
            
            System.out.println("JSON converted to CSV: " + csvFile);
            
        } catch (IOException e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }
    
    // Convert CSV to JSON format
    public static void csvToJSON(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             PrintWriter pw = new PrintWriter(new FileWriter(jsonFile))) {
            
            String line;
            boolean isHeader = true;
            String[] headers = null;
            
            pw.println("[");
            boolean firstRecord = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    headers = line.split(",");
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                
                if (!firstRecord) {
                    pw.println(",");
                }
                
                pw.print("  {");
                for (int i = 0; i < headers.length && i < data.length; i++) {
                    if (i > 0) pw.print(", ");
                    pw.printf("\"%s\": \"%s\"", headers[i].trim(), data[i].trim());
                }
                pw.print("}");
                
                firstRecord = false;
            }
            
            pw.println("\n]");
            System.out.println("CSV converted to JSON: " + jsonFile);
            
        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
    
    // Extract value from JSON line (basic implementation)
    private static String extractValue(String line, String key) {
        String pattern = "\"" + key + "\"\\s*:\\s*\"?([^,}\"]+)\"?";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(line);
        return m.find() ? m.group(1) : "";
    }
}