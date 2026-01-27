import java.util.*;

class Patient {
    private String id;
    private String name;
    
    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "'}";
    }
}

public class HospitalPatientIdPrinting {
    
    // Method to print patient ID (for method reference)
    public static void printPatientId(Patient patient) {
        System.out.println("Patient ID: " + patient.getId());
    }
    
    // Alternative instance method for printing
    public void displayId(Patient patient) {
        System.out.println("ID: " + patient.getId() + " - " + patient.getName());
    }
    
    public static void main(String[] args) {
        // Create list of patients
        List<Patient> patients = Arrays.asList(
            new Patient("P001", "John Doe"),
            new Patient("P002", "Jane Smith"),
            new Patient("P003", "Bob Johnson"),
            new Patient("P004", "Alice Brown")
        );
        
        System.out.println("=== Using Method Reference (Static Method) ===");
        // Using static method reference instead of lambda
        // Instead of: patients.forEach(patient -> printPatientId(patient))
        patients.forEach(HospitalPatientIdPrinting::printPatientId);
        
        System.out.println("\n=== Using Method Reference (Instance Method) ===");
        HospitalPatientIdPrinting hospital = new HospitalPatientIdPrinting();
        // Using instance method reference
        // Instead of: patients.forEach(patient -> hospital.displayId(patient))
        patients.forEach(hospital::displayId);
        
        System.out.println("\n=== Using Method Reference (Built-in Method) ===");
        // Using built-in method reference for printing entire object
        // Instead of: patients.forEach(patient -> System.out.println(patient))
        patients.forEach(System.out::println);
    }
}