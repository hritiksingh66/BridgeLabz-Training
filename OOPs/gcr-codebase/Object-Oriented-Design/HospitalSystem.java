import java.util.*;

// Patient class
class Patient {
    String name;
    String illness;
    List<Doctor> doctors; // Association - patient can see multiple doctors
    
    Patient(String name, String illness) {
        this.name = name;
        this.illness = illness;
        this.doctors = new ArrayList<>();
    }
    
    // Add doctor to patient's list
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    // Show patient's doctors
    void showDoctors() {
        System.out.println(name + " consults with:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
    }
}

// Doctor class
class Doctor {
    String name;
    String specialty;
    List<Patient> patients; // Association - doctor can see multiple patients
    
    Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }
    
    // Communication method - doctor consults with patient
    void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.name);
        System.out.println("Specialty: " + specialty + " | Patient Issue: " + patient.illness);
        
        // Create two-way association
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        if (!patient.doctors.contains(this)) {
            patient.addDoctor(this);
        }
        System.out.println("Consultation completed.\n");
    }
    
    // Show doctor's patients
    void showPatients() {
        System.out.println("Dr. " + name + " treats:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

// Hospital class - contains doctors and patients
class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;
    
    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    
    // Add doctor to hospital
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    // Add patient to hospital
    void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    // Show hospital info
    void showInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Patients: " + patients.size());
    }
}

// Main class to demonstrate the system
public class HospitalSystem {
    public static void main(String[] args) {
        // Create hospital
        Hospital hospital = new Hospital("City General Hospital");
        
        // Create doctors
        Doctor cardio = new Doctor("Smith", "Cardiology");
        Doctor neuro = new Doctor("Johnson", "Neurology");
        Doctor general = new Doctor("Brown", "General Medicine");
        
        // Create patients
        Patient john = new Patient("John", "Heart Problem");
        Patient alice = new Patient("Alice", "Headache");
        Patient bob = new Patient("Bob", "Fever");
        
        // Add to hospital
        hospital.addDoctor(cardio);
        hospital.addDoctor(neuro);
        hospital.addDoctor(general);
        hospital.addPatient(john);
        hospital.addPatient(alice);
        hospital.addPatient(bob);
        
        // Show hospital info
        hospital.showInfo();
        System.out.println();
        
        // Demonstrate consultations (Communication between objects)
        cardio.consult(john);
        neuro.consult(alice);
        general.consult(bob);
        general.consult(alice); // Alice sees multiple doctors
        
        // Show relationships
        john.showDoctors();
        alice.showDoctors();
        System.out.println();
        
        cardio.showPatients();
        neuro.showPatients();
        general.showPatients();
    }
}