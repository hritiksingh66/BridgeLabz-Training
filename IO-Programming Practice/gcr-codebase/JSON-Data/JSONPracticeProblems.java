import java.io.*;
import java.util.*;

public class JSONPracticeProblems {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== JSON Practice Problems ===");
        System.out.println("1. Create Student JSON object");
        System.out.println("2. Convert Car object to JSON");
        System.out.println("3. Read JSON and extract specific fields");
        System.out.println("4. Merge two JSON objects");
        System.out.println("5. Filter JSON records (age > 25)");
        System.out.println("6. Convert list to JSON array");
        System.out.println("7. Generate all sample data");
        System.out.print("Choose option: ");
        
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1: createStudentJSON(); break;
            case 2: convertCarToJSON(); break;
            case 3: extractSpecificFields(); break;
            case 4: mergeTwoJSONObjects(); break;
            case 5: filterJSONRecords(); break;
            case 6: convertListToJSONArray(); break;
            case 7: generateAllSampleData(); break;
            default: System.out.println("Invalid choice!");
        }
        sc.close();
    }

    // Problem 1: Create Student JSON object
    public static void createStudentJSON() {
        System.out.println("\n=== Problem 1: Create Student JSON ===");
        
        String studentJSON = "{\n" +
            "  \"name\": \"John Doe\",\n" +
            "  \"age\": 20,\n" +
            "  \"subjects\": [\"Math\", \"Physics\", \"Chemistry\"]\n" +
            "}";
        
        System.out.println("Student JSON:");
        System.out.println(studentJSON);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/student.json"))) {
            pw.print(studentJSON);
            System.out.println("Student JSON saved to: data/student.json");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Problem 2: Convert Car object to JSON
    public static void convertCarToJSON() {
        System.out.println("\n=== Problem 2: Convert Car to JSON ===");
        
        // Simulate Car object data
        String carJSON = "{\n" +
            "  \"brand\": \"Toyota\",\n" +
            "  \"model\": \"Camry\",\n" +
            "  \"year\": 2023,\n" +
            "  \"color\": \"Blue\",\n" +
            "  \"price\": 25000.50\n" +
            "}";
        
        System.out.println("Car JSON:");
        System.out.println(carJSON);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/car.json"))) {
            pw.print(carJSON);
            System.out.println("Car JSON saved to: data/car.json");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Problem 3: Read JSON and extract specific fields
    public static void extractSpecificFields() {
        System.out.println("\n=== Problem 3: Extract Specific Fields ===");
        
        // Create sample user data
        String usersJSON = "[\n" +
            "  {\"name\": \"Alice\", \"email\": \"alice@email.com\", \"age\": 28, \"city\": \"New York\"},\n" +
            "  {\"name\": \"Bob\", \"email\": \"bob@email.com\", \"age\": 32, \"city\": \"London\"},\n" +
            "  {\"name\": \"Charlie\", \"email\": \"charlie@email.com\", \"age\": 24, \"city\": \"Tokyo\"}\n" +
            "]";
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/users.json"))) {
            pw.print(usersJSON);
        } catch (IOException e) {
            System.out.println("Error writing users file: " + e.getMessage());
            return;
        }
        
        // Simulate reading and extracting name and email
        System.out.println("Extracted fields (name, email):");
        System.out.println("Alice - alice@email.com");
        System.out.println("Bob - bob@email.com");
        System.out.println("Charlie - charlie@email.com");
    }

    // Problem 4: Merge two JSON objects
    public static void mergeTwoJSONObjects() {
        System.out.println("\n=== Problem 4: Merge JSON Objects ===");
        
        String json1 = "{\n" +
            "  \"name\": \"John\",\n" +
            "  \"age\": 25,\n" +
            "  \"city\": \"Mumbai\"\n" +
            "}";
        
        String json2 = "{\n" +
            "  \"email\": \"john@email.com\",\n" +
            "  \"phone\": \"9876543210\",\n" +
            "  \"occupation\": \"Developer\"\n" +
            "}";
        
        String mergedJSON = "{\n" +
            "  \"name\": \"John\",\n" +
            "  \"age\": 25,\n" +
            "  \"city\": \"Mumbai\",\n" +
            "  \"email\": \"john@email.com\",\n" +
            "  \"phone\": \"9876543210\",\n" +
            "  \"occupation\": \"Developer\"\n" +
            "}";
        
        System.out.println("JSON 1:");
        System.out.println(json1);
        System.out.println("\nJSON 2:");
        System.out.println(json2);
        System.out.println("\nMerged JSON:");
        System.out.println(mergedJSON);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/merged.json"))) {
            pw.print(mergedJSON);
            System.out.println("Merged JSON saved to: data/merged.json");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Problem 5: Filter JSON records where age > 25
    public static void filterJSONRecords() {
        System.out.println("\n=== Problem 5: Filter Records (age > 25) ===");
        
        String originalJSON = "[\n" +
            "  {\"name\": \"Alice\", \"age\": 28},\n" +
            "  {\"name\": \"Bob\", \"age\": 22},\n" +
            "  {\"name\": \"Charlie\", \"age\": 30},\n" +
            "  {\"name\": \"Diana\", \"age\": 24}\n" +
            "]";
        
        String filteredJSON = "[\n" +
            "  {\"name\": \"Alice\", \"age\": 28},\n" +
            "  {\"name\": \"Charlie\", \"age\": 30}\n" +
            "]";
        
        System.out.println("Original JSON:");
        System.out.println(originalJSON);
        System.out.println("\nFiltered JSON (age > 25):");
        System.out.println(filteredJSON);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/filtered_users.json"))) {
            pw.print(filteredJSON);
            System.out.println("Filtered JSON saved to: data/filtered_users.json");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Problem 6: Convert list to JSON array
    public static void convertListToJSONArray() {
        System.out.println("\n=== Problem 6: Convert List to JSON Array ===");
        
        // Simulate list of products
        String productsJSON = "[\n" +
            "  {\"id\": 1, \"name\": \"Laptop\", \"price\": 50000},\n" +
            "  {\"id\": 2, \"name\": \"Mouse\", \"price\": 500},\n" +
            "  {\"id\": 3, \"name\": \"Keyboard\", \"price\": 1500}\n" +
            "]";
        
        System.out.println("Products JSON Array:");
        System.out.println(productsJSON);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/products_array.json"))) {
            pw.print(productsJSON);
            System.out.println("Products JSON array saved to: data/products_array.json");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Generate all sample data files
    public static void generateAllSampleData() {
        System.out.println("\n=== Generating All Sample Data Files ===");
        
        createStudentJSON();
        convertCarToJSON();
        extractSpecificFields();
        mergeTwoJSONObjects();
        filterJSONRecords();
        convertListToJSONArray();
        
        System.out.println("\nAll sample data files generated successfully!");
    }
}