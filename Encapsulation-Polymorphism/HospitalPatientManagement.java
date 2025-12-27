import java.util.*;

// Abstract base class for patients - demonstrates encapsulation
abstract class Patient {
    // Private fields - encapsulated data
    private int patientId;
    private String name;
    private int age;

    // Constructor to initialize patient
    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getter methods for accessing private fields
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method to get patient details
    public String getPatientDetails() {
        return "Patient ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }

    // Abstract method - must be implemented by child classes
    public abstract double calculateBill();
}

// Interface for medical record functionality
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// In-patient class extends Patient and implements MedicalRecord
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalRecords;

    // Constructor calls parent constructor
    InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalRecords = new ArrayList<>();
    }

    // Implementation of abstract method - bill based on days and daily rate
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    // Implementation of interface method
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    // Implementation of interface method
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

// Out-patient class extends Patient and implements MedicalRecord
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    // Constructor calls parent constructor
    OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    // Implementation of abstract method - bill is consultation fee
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Implementation of interface method
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    // Implementation of interface method
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

// Utility class to process patient bills - demonstrates polymorphism
class PatientManager {
    public static void processPatientBill(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Bill Amount: " + patient.calculateBill());
        
        // Check if patient implements MedicalRecord interface
        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            record.viewRecords();
        }
    }
}

// Main class to demonstrate hospital patient management
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Create in-patient and add medical records
        InPatient inPatient = new InPatient(1, "John Doe", 45, 5, 1000);
        inPatient.addRecord("Admitted with fever and fatigue.");
        inPatient.addRecord("Undergoing tests for viral infection.");

        // Create out-patient and add medical record
        OutPatient outPatient = new OutPatient(2, "Jane Smith", 30, 200);
        outPatient.addRecord("Consulted for routine check-up.");

        // Process both patients using polymorphism
        System.out.println("Processing In-Patient:");
        PatientManager.processPatientBill(inPatient);

        System.out.println("\nProcessing Out-Patient:");
        PatientManager.processPatientBill(outPatient);
    }
}
